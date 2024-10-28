package com.example.controller;

import com.example.dto.ProductResponseDto;
import com.example.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/getByProductId")
    public ProductResponseDto getByProductId(@RequestParam(name = "id") Long productId) {
        return productService.getByProductId(productId);
    }

    @GetMapping(value = "/getByUserId")
    public List<ProductResponseDto> getByUserId(@RequestParam(name = "id") Long userId) {
        return productService.getByUserId(userId);
    }

    @GetMapping(value = "/getByUser")
    public List<ProductResponseDto> getByUser(@RequestParam(name = "id") Long userId) {
        return productService.getByUser(userId);
    }

    @GetMapping(value = "/getByUserIdSet")
    public Set<ProductResponseDto> getByUserIdSet(@RequestParam(name = "id") Long userId) {
        return productService.getByUserIdSet(userId);
    }
}
