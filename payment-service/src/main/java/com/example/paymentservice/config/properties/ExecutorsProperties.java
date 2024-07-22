package com.example.paymentservice.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@ConfigurationProperties(prefix = "integrations.executors")
public class ExecutorsProperties {
    private final RestTemplateProperties paymentExecutorClient;

    @ConstructorBinding
    public ExecutorsProperties(RestTemplateProperties paymentExecutorClient) {
        this.paymentExecutorClient = paymentExecutorClient;
    }

    public RestTemplateProperties getPaymentExecutorClient() {
        return paymentExecutorClient;
    }
}
