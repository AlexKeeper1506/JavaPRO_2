package com.example.service;

import com.example.entity.Product;
import com.example.exception.ProductBalanceTooLowException;
import com.example.exception.ProductNotFoundException;
import com.example.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getByProductId(Long productId) {
        Product product =  productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("There's no product with the given ID", HttpStatus.NOT_FOUND)
        );

        if (product.getBalance().compareTo(BigDecimal.valueOf(200.00)) == -1) throw new ProductBalanceTooLowException("The balance of the found product is less than 200 rubles", HttpStatus.BAD_REQUEST);
        else return product;
    }

    /*public List<Product> getByUserId(Long userId) throws SQLException {
        return productRepository.selectByUserId(userId);
    }*/
}
