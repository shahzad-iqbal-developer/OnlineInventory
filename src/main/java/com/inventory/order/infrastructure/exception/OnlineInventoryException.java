package com.inventory.order.infrastructure.exception;

import org.springframework.http.HttpStatus;


public class OnlineInventoryException extends RuntimeException {

    public OnlineInventoryException(String message) {
        super(message);
    }
}
