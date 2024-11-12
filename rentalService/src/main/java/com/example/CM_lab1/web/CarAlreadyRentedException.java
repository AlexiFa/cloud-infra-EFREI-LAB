package com.example.CM_lab1.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CarAlreadyRentedException extends Exception{
    public CarAlreadyRentedException(String message) {
        super(message);
    }
}
