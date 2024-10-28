package com.example.repository;

import com.example.entity.Product;
import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT id, account_number, balance, type, user_id " +
            "FROM products " +
            "WHERE user_id = :userId", nativeQuery = true)
    List<Product> findByUserId(Long userId);

    List<Product> findByUser(User user);
}
