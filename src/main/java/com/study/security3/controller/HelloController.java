package com.study.security3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    // 어드민만 볼 수 있게
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    //매니저만 볼 수 있게
    @GetMapping("/ciao")
    public String ciao() {
        return "Ciao";
    }

    //얘는 따로 엔드포인트 설정이 안 되어서
    //아무나 접근 가능!
    //명시적으로 permitAll() 로 지정하는 습관을 들이자
    @GetMapping("/hola")
    public String hola() {
        return "Hola";
    }
}
