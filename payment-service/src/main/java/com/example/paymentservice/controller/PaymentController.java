package com.example.paymentservice.controller;

import com.example.paymentservice.dto.ProductResponseDto;
import com.example.paymentservice.service.ExecutorProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    private final ExecutorProductService executorProductService;

    public PaymentController(ExecutorProductService executorProductService) {
        this.executorProductService = executorProductService;
    }

    @GetMapping(value = "/getProductById")
    public ProductResponseDto getProductById(@RequestParam(name = "id") Long productId) {
        return executorProductService.getProductById(productId);
    }
}
