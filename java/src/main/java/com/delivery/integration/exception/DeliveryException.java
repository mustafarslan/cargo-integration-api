package com.delivery.integration.exception;

public class DeliveryException extends Exception {
    public DeliveryException() {}

    public DeliveryException(String message) {
        super(message);
    }

    public DeliveryException(String message, Throwable cause) {
        super(message, cause);
    }
}
