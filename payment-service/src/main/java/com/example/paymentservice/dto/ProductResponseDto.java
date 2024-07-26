package com.example.paymentservice.dto;

public class ProductResponseDto {
    private final Long id;
    private final String accountNumber;
    private final Double balance;
    private final String type;
    private final Long userId;

    public ProductResponseDto(Long id, String accountNumber, Double balance, String type, Long userId) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.type = type;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public String getType() {
        return type;
    }

    public Long getUserId() {
        return userId;
    }
}
