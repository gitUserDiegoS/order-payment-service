package com.ecommerce.orderpaymentservice.domain.model.order;

import com.ecommerce.orderpaymentservice.domain.model.orderitem.OrderItem;
import com.ecommerce.orderpaymentservice.domain.model.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
