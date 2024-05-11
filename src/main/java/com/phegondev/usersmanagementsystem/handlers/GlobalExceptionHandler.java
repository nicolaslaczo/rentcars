package com.phegondev.usersmanagementsystem.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarsNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerVehicleNotFoundException(CarsNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(CustomerFoundException.class)
    public ResponseEntity<ErrorResponse> handlerCustomerFoundException(CustomerFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.FOUND).body(errorResponse);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerCustomerNotFoundException(CustomerNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}

