package com.ecommerce.orderpaymentservice.domain.model.order;

import com.ecommerce.orderpaymentservice.domain.model.orderitem.OrderItem;

import lombok.*;


import java.math.BigDecimal;
import java.util.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private String status;
    private Date dateCreated;
    private Date lastUpdated;
    private Long userId;

    private List<OrderItem> items;


}
