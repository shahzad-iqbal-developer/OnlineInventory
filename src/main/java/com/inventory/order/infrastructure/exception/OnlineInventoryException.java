package com.inventory.order.infrastructure.exception;

import org.springframework.http.HttpStatus;


public class OnlineInventoryException extends RuntimeException {
    private final HttpStatus status;

    public OnlineInventoryException(HttpStatus httpStatus, String message) {
        super(message);
        status = httpStatus;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
