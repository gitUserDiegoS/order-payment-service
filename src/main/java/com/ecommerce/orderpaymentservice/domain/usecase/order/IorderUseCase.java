package com.ecommerce.orderpaymentservice.domain.usecase.order;


import com.ecommerce.orderpaymentservice.domain.model.order.Order;
import com.ecommerce.orderpaymentservice.domain.model.order.OrderStatus;

import com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto.CreateOrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IorderUseCase {

    Order createOrder(CreateOrderDto dto, String token);

    Page<Order> getOrderHistory(Long userId, OrderStatus status, Pageable pageable);
}
