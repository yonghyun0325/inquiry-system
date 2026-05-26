package com.example.inquirysystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationException(
            MethodArgumentNotValidException e
    ) {

        Map<String, String> response = new HashMap<>();

        String errorMessage =
                e.getBindingResult()
                        .getFieldError()
                        .getDefaultMessage();

        response.put("message", errorMessage);

        return response;
    }
}