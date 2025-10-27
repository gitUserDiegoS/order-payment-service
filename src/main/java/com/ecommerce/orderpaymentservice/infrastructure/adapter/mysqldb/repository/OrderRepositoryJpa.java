package com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.repository;

import com.ecommerce.orderpaymentservice.domain.model.order.OrderStatus;
import com.ecommerce.orderpaymentservice.infrastructure.adapter.mysqldb.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderRepositoryJpa extends JpaRepository<OrderEntity, Long> {

    Page<OrderEntity> findByUserIdAndStatus(Long id, OrderStatus status, Pageable pageable);

    Page<OrderEntity> findByUserId(Long userId, Pageable pageable);
}
