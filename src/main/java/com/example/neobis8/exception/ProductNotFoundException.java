package com.example.neobis8.exception;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException() {
        super("Продукт не найден");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
