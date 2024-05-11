package com.phegondev.usersmanagementsystem.handlers;

public class CustomerFoundException extends RuntimeException{

    public CustomerFoundException(String email) {
        super("Customer exist in database");
    }
}
