package com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.mapper;

import com.ecommerce.orderpaymentservice.domain.model.order.Order;
import com.ecommerce.orderpaymentservice.domain.model.orderitem.OrderItem;
import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.entity.OrderEntity;
import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.entity.OrderItemEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


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
