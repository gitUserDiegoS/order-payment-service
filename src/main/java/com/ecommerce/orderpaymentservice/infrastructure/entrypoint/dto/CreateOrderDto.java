package com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderDto {
    private Long userId;
    private List<OrderItemDto> items;
}
