package com.study.security3.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerC {

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }
}
