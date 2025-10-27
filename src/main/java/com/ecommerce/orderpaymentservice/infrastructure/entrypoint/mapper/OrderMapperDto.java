package com.ecommerce.orderpaymentservice.infrastructure.entrypoint.mapper;

import com.ecommerce.orderpaymentservice.domain.model.order.Order;
import com.ecommerce.orderpaymentservice.domain.model.orderitem.OrderItem;
import com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto.OrderItemDto;
import com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto.OrderResponseDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapperDto {

    // Map CreateOrderDto to list of OrderItem domain objects
    default List<OrderItem> toDomainItems(List<OrderItemDto> dtos) {
        if (dtos == null) return null;
        return dtos.stream()
                .map(dto -> OrderItem.builder()
                        .productId(dto.getProductId())
                        .quantity(dto.getQuantity())
                        .build())
                .toList();
    }

    // Map Order domain to response DTO
    @Mapping(target = "items", source = "items")
    OrderResponseDto toResponse(Order order);

    // Map OrderItem domain to OrderItemDto
    default OrderItemDto toDto(OrderItem item) {
        if (item == null) return null;
        OrderItemDto dto = new OrderItemDto();
        dto.setProductId(item.getProductId());
        dto.setQuantity(item.getQuantity());
        return dto;
    }

}
