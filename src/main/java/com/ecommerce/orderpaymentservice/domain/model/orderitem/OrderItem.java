package com.ecommerce.orderpaymentservice.domain.model.orderitem;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    private Long id;
    private int quantity;
    private BigDecimal unitPrice;
    private Long productId;

}
