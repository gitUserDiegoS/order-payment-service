package com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.mapper;

import com.ecommerce.orderpaymentservice.domain.model.order.Order;
import com.ecommerce.orderpaymentservice.domain.model.orderitem.OrderItem;
import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.entity.OrderEntity;
import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.entity.OrderItemEntity;
import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.entity.UserEntity;
import com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto.CreateOrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "orderItems", source = "items")
    @Mapping(target = "user.id", source = "userId")
    OrderEntity toEntity(Order order);

    @Mapping(target = "items", source = "orderItems")
    @Mapping(target = "userId", source = "user.id")
    Order toDomain(OrderEntity entity);

    List<OrderItem> toDomainItems(List<OrderItemEntity> entities);

    List<OrderItemEntity> toEntityItems(List<OrderItem> items);
}
