package com.example.demo.exception;

import org.springframework.web.bind.annotation.*;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ApiError illegalArg(IllegalArgumentException ex) {
        return new ApiError(ex.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ApiError notFound(NoSuchElementException ex) {
        return new ApiError(ex.getMessage());
    }
}
