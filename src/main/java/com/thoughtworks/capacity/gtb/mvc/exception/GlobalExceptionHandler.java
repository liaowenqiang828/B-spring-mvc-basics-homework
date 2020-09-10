package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RegisterFailedException.class)
    public ResponseEntity<ErrorResult> handler(RegisterFailedException exception) {
        String message = exception.getMessage();
        ErrorResult errorResult = new ErrorResult(message, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(errorResult);
    }

    @ExceptionHandler(UsernameOrPasswordNotMatchException.class)
    public ResponseEntity<ErrorResult> handler(UsernameOrPasswordNotMatchException exception) {
        String message = exception.getMessage();
        ErrorResult errorResult = new ErrorResult(message, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(errorResult);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handler(MethodArgumentNotValidException exception) {

        String message = Objects.requireNonNull(exception.getBindingResult().getFieldError()).getDefaultMessage();

        ErrorResult errorResult = new ErrorResult(message, HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(errorResult);
    }
}
