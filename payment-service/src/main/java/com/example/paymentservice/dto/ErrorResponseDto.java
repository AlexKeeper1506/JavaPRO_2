package com.example.paymentservice.dto;

public class ErrorResponseDto {
    private final Integer errorCode;
    private final String errorMessage;

    public ErrorResponseDto(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
