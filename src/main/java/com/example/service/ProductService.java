package com.example.service;

import com.example.dto.Product;
import com.example.repository.ProductDAO;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product getByProductId(Long productId) throws SQLException {
        return productDAO.selectByProductId(productId);
    }

    public List<Product> getByUserId(Long userId) throws SQLException {
        return productDAO.selectByUserId(userId);
    }
}
