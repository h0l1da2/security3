package com.study.security3.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerD {

    @GetMapping("/video/{country}/{language}")
    public String vide(
            @PathVariable String country,
            @PathVariable String language
    ) {
        return "Video allowed for "+country+" "+language;
    }
}
