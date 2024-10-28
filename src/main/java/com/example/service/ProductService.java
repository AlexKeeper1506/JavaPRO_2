package com.example.service;

import com.example.dto.ProductResponseDto;
import com.example.entity.Product;
import com.example.entity.User;
import com.example.exception.ProductBalanceTooLowException;
import com.example.exception.ProductNotFoundException;
import com.example.repository.ProductRepository;
import com.example.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public ProductResponseDto getByProductId(Long productId) {
        Product product =  productRepository.findById(productId).orElseThrow(
                () -> new ProductNotFoundException("There's no product with the given ID", HttpStatus.NOT_FOUND)
        );

        if (product.getBalance().compareTo(BigDecimal.valueOf(200.00)) == -1) throw new ProductBalanceTooLowException("The balance of the found product is less than 200 rubles", HttpStatus.BAD_REQUEST);
        else {
            ProductResponseDto productDto = new ProductResponseDto(
                    product.getId(),
                    product.getAccountNumber(),
                    product.getBalance(),
                    product.getType(),
                    product.getUser().getId()
            );

            return productDto;
        }
    }

    @Transactional
    public List<ProductResponseDto> getByUserId(Long userId) {
        List<Product> productList = productRepository.findByUserId(userId);

        List<ProductResponseDto> productDtoList = new ArrayList<>();

        for (Product product : productList) {
            productDtoList.add(new ProductResponseDto(
                    product.getId(),
                    product.getAccountNumber(),
                    product.getBalance(),
                    product.getType(),
                    product.getUser().getId()
            ));
        }

        return productDtoList;
    }

    @Transactional
    public List<ProductResponseDto> getByUser(Long userId) {
        User user = new User();
        user.setId(userId);

        List<Product> productList = productRepository.findByUser(user);

        List<ProductResponseDto> productDtoList = new ArrayList<>();

        for (Product product : productList) {
            productDtoList.add(new ProductResponseDto(
                    product.getId(),
                    product.getAccountNumber(),
                    product.getBalance(),
                    product.getType(),
                    product.getUser().getId()
            ));
        }

        return productDtoList;
    }

    public Set<ProductResponseDto> getByUserIdSet(Long userId) {
        User user = userRepository.findByIdWithinProducts(userId).orElseThrow(EntityNotFoundException::new);

        Set<Product> productSet = user.getProducts();
        Set<ProductResponseDto> productDtoSet = new HashSet<>();

        for (Product product : productSet) {
            productDtoSet.add(new ProductResponseDto(
                    product.getId(),
                    product.getAccountNumber(),
                    product.getBalance(),
                    product.getType(),
                    product.getUser().getId()
            ));
        }

        return productDtoSet;
    }
}
