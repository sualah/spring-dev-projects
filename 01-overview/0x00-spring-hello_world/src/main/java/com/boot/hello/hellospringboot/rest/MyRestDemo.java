package com.boot.hello.hellospringboot.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestDemo {

    @GetMapping("/")
    public String sayHello() {
        return "Hello Spring Boot";
    }
}
