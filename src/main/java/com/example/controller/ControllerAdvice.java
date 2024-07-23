package com.example.controller;

import com.example.dto.ErrorResponseDto;
import com.example.exception.ProductBalanceTooLowException;
import com.example.exception.ProductNotFoundException;
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

    @ExceptionHandler(ProductBalanceTooLowException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponseDto handleProductBalanceTooLowException(ProductBalanceTooLowException exception) {
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
