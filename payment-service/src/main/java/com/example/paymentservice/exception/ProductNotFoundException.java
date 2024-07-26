package com.example.paymentservice.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RuntimeException {
    private HttpStatus httpStatus;

    public ProductNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
