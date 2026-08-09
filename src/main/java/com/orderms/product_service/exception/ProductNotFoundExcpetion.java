package com.orderms.product_service.exception;

public class ProductNotFoundExcpetion extends RuntimeException {
    public ProductNotFoundExcpetion(String message) {
        super(message);
    }
}
