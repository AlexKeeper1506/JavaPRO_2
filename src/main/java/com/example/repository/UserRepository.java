package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph("User.with-products")
    @Query("SELECT u FROM User u WHERE u.id = :userId")
    Optional<User> findByIdWithinProducts(Long userId);
}
