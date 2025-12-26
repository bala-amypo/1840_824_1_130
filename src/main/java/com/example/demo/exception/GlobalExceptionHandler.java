package com.example.demo.exception;

import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ApiError handleIllegal(IllegalArgumentException ex) {
        return new ApiError(ex.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ApiError handleNotFound(NoSuchElementException ex) {
        return new ApiError(ex.getMessage());
    }
}
