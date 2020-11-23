package com.inventory.order.infrastructure.common;

public enum Constants {

    ORDER_NOT_FOUND("Order not found");

    String value;
    Constants(String value){
        this.value =value;
    }

    public String getValue() {
        return value;
    }
}
