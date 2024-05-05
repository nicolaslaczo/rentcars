package com.phegondev.usersmanagementsystem.handlers;

public class RentCarsNotFoundException extends RuntimeException{

    public RentCarsNotFoundException(Long id) {
        super(id + " don't exist");
    }
}
