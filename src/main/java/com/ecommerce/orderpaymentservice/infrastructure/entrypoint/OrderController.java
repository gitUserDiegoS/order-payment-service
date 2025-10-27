package com.ecommerce.orderpaymentservice.infrastructure.entrypoint;


import com.ecommerce.orderpaymentservice.domain.model.order.Order;
import com.ecommerce.orderpaymentservice.domain.model.order.OrderStatus;
import com.ecommerce.orderpaymentservice.domain.usecase.order.IorderUseCase;
import com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto.CreateOrderDto;
import com.ecommerce.orderpaymentservice.infrastructure.entrypoint.dto.OrderResponseDto;
import com.ecommerce.orderpaymentservice.infrastructure.entrypoint.mapper.OrderMapperDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for managing orders, used for CRUD operations
 */
@Tag(name = "Order", description = "Operations related to placed orders")
@Slf4j
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {


    private final IorderUseCase useCase;
    private final OrderMapperDto mapperDto;

    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody CreateOrderDto dto,
                                                        @RequestHeader("Authorization") String authHeader) {
        Order order = useCase.createOrder(dto, authHeader);
        return ResponseEntity.ok(mapperDto.toResponse(order));
    }

    @GetMapping
    public Page<OrderResponseDto> getOrderHistory(
            @RequestParam Long userId,
            @RequestParam(required = false) OrderStatus status,
            Pageable pageable
    ) {
        return useCase.getOrderHistory(userId, status, pageable)
                .map(mapperDto::toResponse);
    }
}
