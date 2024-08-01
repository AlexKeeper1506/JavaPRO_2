package com.example.service;

import com.example.entity.Product;
import com.example.exception.ProductBalanceTooLowException;
import com.example.exception.ProductNotFoundException;
import com.example.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public Product getByProductId(Long productId) {
        Product product =  productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("There's no product with the given ID", HttpStatus.NOT_FOUND)
        );

        if (product.getBalance().compareTo(BigDecimal.valueOf(200.00)) == -1) throw new ProductBalanceTooLowException("The balance of the found product is less than 200 rubles", HttpStatus.BAD_REQUEST);
        else return product;
    }

    @Transactional
    public List<Product> getByUserId(Long userId) {
        return productRepository.findByUserId(userId);
    }
}
