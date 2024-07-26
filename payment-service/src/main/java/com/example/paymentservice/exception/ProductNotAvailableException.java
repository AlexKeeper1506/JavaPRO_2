package com.example.paymentservice.exception;

import org.springframework.http.HttpStatus;

public class ProductNotAvailableException extends RuntimeException {
    private HttpStatus httpStatus;

    public ProductNotAvailableException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
