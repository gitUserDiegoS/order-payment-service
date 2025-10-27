package com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb;


import com.ecommerce.orderpaymentservice.domain.model.order.Order;
import com.ecommerce.orderpaymentservice.domain.model.order.OrderStatus;
import com.ecommerce.orderpaymentservice.domain.model.order.gateway.OrderRepository;
import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.entity.OrderEntity;
import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.mapper.OrderMapper;
import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.repository.OrderRepositoryJpa;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 * Adapter MySql that supports queries to the database
 */
@Component
@RequiredArgsConstructor
public class OrderRepositoryAdapter implements OrderRepository {

    private final OrderRepositoryJpa repositoryJpa;
    private final OrderMapper mapper;

    @Override
    public Order save(Order order) {
        OrderEntity entity = mapper.toEntity(order);
        OrderEntity saved = repositoryJpa.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Page<Order> findByUserId(Long userId, Pageable pageable) {
        return repositoryJpa.findByUserId(userId, pageable)
                .map(mapper::toDomain);
    }

    @Override
    public Page<Order> findByUserIdAndStatus(Long userId, OrderStatus status, Pageable pageable) {
        return repositoryJpa.findByUserIdAndStatus(userId, status, pageable)
                .map(mapper::toDomain);
    }
}
