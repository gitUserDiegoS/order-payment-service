package com.ecommerce.orderpaymentservice.domain.usecase.order;


import com.ecommerce.orderpaymentservice.domain.model.order.Order;
import com.ecommerce.orderpaymentservice.domain.model.order.OrderStatus;
import com.ecommerce.orderpaymentservice.domain.model.order.gateway.OrderRepository;
import com.ecommerce.orderpaymentservice.domain.model.orderitem.OrderItem;


import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.mapper.OrderMapper;

import com.ecommerce.orderpaymentservice.infrastructure.adapter.serviceclient.ProductClient;

import com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto.CreateOrderDto;
import com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto.OrderItemDto;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * UseCase for handling order operations
 */
@Service
@RequiredArgsConstructor
public class OrderUseCase implements IorderUseCase {


    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper mapper;

    @Override
    @Transactional
    public Order createOrder(CreateOrderDto dto, String authHeader) {
        Order order = new Order();
        order.setUserId(dto.getUserId());
        order.setStatus("PENDING");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());

        BigDecimal totalPrice = BigDecimal.ZERO;
        int totalQuantity = 0;
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemDto itemDto : dto.getItems()) {
            var product = productClient.getProductById(itemDto.getProductId(), authHeader);

            BigDecimal itemPrice = product.getUnitPrice().multiply(BigDecimal.valueOf(itemDto.getQuantity()));
            totalPrice = totalPrice.add(itemPrice);
            totalQuantity += itemDto.getQuantity();

            orderItems.add(OrderItem.builder()
                    .productId(product.getId())
                    .quantity(itemDto.getQuantity())
                    .unitPrice(product.getUnitPrice())
                    .build());
        }

        order.setItems(orderItems);
        order.setTotalPrice(totalPrice);
        order.setTotalQuantity(totalQuantity);


        return orderRepository.save(order);

    }

    @Override
    public Page<Order> getOrderHistory(Long userId, OrderStatus status, Pageable pageable) {
        return null;

    }


}
