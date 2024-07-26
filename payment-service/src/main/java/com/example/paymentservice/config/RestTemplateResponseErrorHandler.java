package com.example.paymentservice.config;

import com.example.paymentservice.exception.ProductNotAvailableException;
import com.example.paymentservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        HttpStatusCode statusCode = response.getStatusCode();
        return statusCode.is4xxClientError() || statusCode.is5xxServerError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        HttpStatusCode statusCode = response.getStatusCode();

        if (statusCode.equals(HttpStatus.NOT_FOUND)) throw new ProductNotFoundException("No product was returned", HttpStatus.NOT_FOUND);
        else if (statusCode.equals(HttpStatus.BAD_REQUEST)) throw new ProductNotAvailableException("The found product cannot be used", HttpStatus.BAD_REQUEST);
        else if (statusCode.is5xxServerError()) throw new RuntimeException("The product service returned an internal server error");
    }
}
