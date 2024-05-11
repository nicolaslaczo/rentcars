package com.phegondev.usersmanagementsystem.handlers;

public class CarsNotFoundException extends RuntimeException{

    public CarsNotFoundException(Long id) {
        super(id + " don't exist");
    }
}
