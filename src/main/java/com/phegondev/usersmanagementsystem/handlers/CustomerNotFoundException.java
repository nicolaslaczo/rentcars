package com.phegondev.usersmanagementsystem.handlers;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Long id) {
        super("Customer with " + id + " doesn't exists");
    }
}
