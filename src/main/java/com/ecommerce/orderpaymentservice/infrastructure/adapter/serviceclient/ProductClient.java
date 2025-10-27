package com.ecommerce.orderpaymentservice.infrastructure.adapter.serviceclient;

import com.ecommerce.orderpaymentservice.infrastructure.adapter.serviceclient.dto.ProductResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ProductClient {

    private final WebClient webClient;

    public ProductClient(WebClient productServiceWebClient) {
        this.webClient = productServiceWebClient;
    }

    public ProductResponseDto getProductById(Long productId, String token) {
        return webClient.get()
                .uri("/api/v1/products/{id}", productId)
                .header(HttpHeaders.AUTHORIZATION, token)
                .retrieve()
                .bodyToMono(ProductResponseDto.class)
                .block();
    }
}
