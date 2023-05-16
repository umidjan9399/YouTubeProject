package com.example.exps;

import org.springframework.web.bind.annotation.ControllerAdvice;


public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message) {
        super(message);
    }
}
