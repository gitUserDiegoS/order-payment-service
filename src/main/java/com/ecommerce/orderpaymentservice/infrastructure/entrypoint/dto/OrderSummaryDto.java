package com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSummaryDto {
    private Long id;
    private String status;
    private BigDecimal totalPrice;
}
