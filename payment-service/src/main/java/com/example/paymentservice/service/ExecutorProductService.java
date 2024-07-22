package com.example.paymentservice.service;

import com.example.paymentservice.config.properties.ExecutorsProperties;
import com.example.paymentservice.config.properties.RestTemplateProperties;
import com.example.paymentservice.dto.ProductResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExecutorProductService {
    private final RestTemplate restTemplate;
    private final RestTemplateProperties executorProductClientProperties;

    public ExecutorProductService(RestTemplate restTemplate, ExecutorsProperties executorsProperties) {
        this.restTemplate = restTemplate;
        this.executorProductClientProperties = executorsProperties.getPaymentExecutorClient();
    }

    public ProductResponseDto getProductById(Long productId) {
        return restTemplate.getForObject(
                executorProductClientProperties.getUrl() + "/product/getByProductId?id=" + productId,
                ProductResponseDto.class
        );
    }
}
