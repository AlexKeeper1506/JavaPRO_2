package com.example.dto;

import java.math.BigDecimal;

public class ProductResponseDto {
    private final Long id;
    private final String accountNumber;
    private final BigDecimal balance;
    private final String type;
    private final Long userId;



    public Long getId() {
        return id;
    }

    public ProductResponseDto(Long id, String accountNumber, BigDecimal balance, String type, Long userId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public Long getUserId() {
        return userId;
    }
}
