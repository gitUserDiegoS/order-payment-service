package com.ecommerce.orderpaymentservice.domain.model.order;

import com.ecommerce.orderpaymentservice.domain.model.orderitem.OrderItem;
import com.ecommerce.orderpaymentservice.domain.model.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;


    private String orderTrackingNumber;


    private int totalQuantity;


    private BigDecimal totalPrice;


    private String status;



    private Date dateCreated;


    private Date lastUpdate;


    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    
    public void add(OrderItem item) {

        if (item != null) {
            if (orderItems == null) {
                orderItems = new HashSet<>();
            }

            orderItems.add(item);
            item.setOrder(this);
        }

    }

}
