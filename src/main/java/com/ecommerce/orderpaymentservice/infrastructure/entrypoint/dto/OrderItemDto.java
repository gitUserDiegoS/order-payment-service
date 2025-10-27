package com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long productId;
    private int quantity;

}
