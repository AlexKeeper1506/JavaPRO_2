package com.example.service;

import com.example.dto.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getByProductId(Long productId) throws SQLException {
        return productRepository.selectByProductId(productId);
    }

    public List<Product> getByUserId(Long userId) throws SQLException {
        return productRepository.selectByUserId(userId);
    }
}
