package com.example.controller;

import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/getByProductId")
    public Product getByProductId(@RequestParam(name = "id") Long productId) throws SQLException {
        return productService.getByProductId(productId);
    }

    /*@GetMapping(value = "/getByUserId")
    public List<Product> getByUserId(@RequestParam(name = "id") Long userId) throws SQLException {
        return productService.getByUserId(userId);
    }*/
}
