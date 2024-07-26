package com.example.paymentservice.controller;

import com.example.paymentservice.dto.ErrorResponseDto;
import com.example.paymentservice.exception.ProductNotAvailableException;
import com.example.paymentservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponseDto handleProductNotFoundException(ProductNotFoundException exception) {
        return new ErrorResponseDto(
                exception.getHttpStatus().value(),
                exception.getMessage()
        );
    }

    @ExceptionHandler(ProductNotAvailableException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleProductBalanceTooLowException(ProductNotAvailableException exception) {
        return new ErrorResponseDto(
                exception.getHttpStatus().value(),
                exception.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseDto handleException(Exception exception) {
        return new ErrorResponseDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage()
        );
    }
}
