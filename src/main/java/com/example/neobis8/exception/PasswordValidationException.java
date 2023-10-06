package com.example.neobis8.exception;

public class PasswordValidationException extends RuntimeException{
    public PasswordValidationException(String message){
        super(message);
    }
}
