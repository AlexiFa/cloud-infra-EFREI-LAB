package com.example.CM_lab1;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloService {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
