package com.example.javaapi;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloService {
    @GetMapping("/hello")
    public String hello() {return "hello";}
}