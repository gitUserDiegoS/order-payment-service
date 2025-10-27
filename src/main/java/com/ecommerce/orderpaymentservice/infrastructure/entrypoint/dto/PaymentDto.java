package com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto;

import lombok.Data;

@Data
public class PaymentDto {
    private String paymentMethod;
    private boolean paid;
}
