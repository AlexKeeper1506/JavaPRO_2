package com.example.paymentservice.service;

import com.example.paymentservice.dto.ProductResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExecutorProductService {
    private final RestTemplate executorRestClient;

    public ExecutorProductService(RestTemplate executorRestClient) {
        this.executorRestClient = executorRestClient;
    }

    public ProductResponseDto getProductById(Long productId) {
        return executorRestClient.getForObject(
                "/product/getByProductId?id=" + productId,
                ProductResponseDto.class
        );
    }
}
