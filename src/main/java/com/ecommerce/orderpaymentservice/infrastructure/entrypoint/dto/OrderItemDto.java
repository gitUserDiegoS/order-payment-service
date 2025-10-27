package com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto;

import lombok.Data;


@Data
public class OrderItemDto {
    private Long productId;
    private int quantity;

}
