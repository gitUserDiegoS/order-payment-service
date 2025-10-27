package com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@Getter
@Setter
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;
    private BigDecimal unitPrice;
    private Long productId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
}
