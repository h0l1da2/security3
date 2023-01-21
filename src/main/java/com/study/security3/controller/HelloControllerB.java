package com.study.security3.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerB {

    @PostMapping("/a")
    public String postEndpointA() {
        return "Work";
    }

    @GetMapping("/a")
    public String getEndpointA() {
        return "Work";
    }

    @GetMapping("/a/b")
    public String getEndpointB() {
        return "Work";
    }

    @GetMapping("/a/b/c")
    public String getEndpointC() {
        return "Work";
    }

    @GetMapping("/product/{code}")
    public String productCode(@PathVariable String code) {
        return code;
    }
}
