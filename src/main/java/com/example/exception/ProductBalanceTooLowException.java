package com.example.exception;

import org.springframework.http.HttpStatus;

public class ProductBalanceTooLowException extends RuntimeException {
    private HttpStatus httpStatus;

    public ProductBalanceTooLowException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
