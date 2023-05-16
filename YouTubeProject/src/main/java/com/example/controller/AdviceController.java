package com.example.controller;

import com.example.exps.AppBadRequestException;
import com.example.exps.ItemNotFoundException;
import com.example.exps.MethodNotAllowedException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.RuleBasedCollator;
@ControllerAdvice
public class AdviceController {
    @ExceptionHandler({AppBadRequestException.class, ItemNotFoundException.class,
            ItemNotFoundException.class, MethodNotAllowedException.class,
            MetaDataAccessException.class})
    public ResponseEntity<String> handleException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}