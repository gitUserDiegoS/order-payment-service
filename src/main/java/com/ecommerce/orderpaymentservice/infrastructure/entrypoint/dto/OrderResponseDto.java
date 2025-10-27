package com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto;

import com.ecommerce.orderpaymentservice.domain.model.order.OrderStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
@Builder
public class OrderResponseDto {

    private Long id;
    private String orderTrackingNumber;
    private BigDecimal totalPrice;
    private int totalQuantity;
    private String status;
    private Date dateCreated;
    private List<OrderItemDto> items;
    //private PaymentDto payment;
}
