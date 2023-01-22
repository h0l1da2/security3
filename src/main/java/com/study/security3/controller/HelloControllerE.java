package com.study.security3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * csrf 공격을 막는(사용자 위조 요청)
 * csrf 설정을 해봅시다
 */
@Controller
public class HelloControllerE {

    @GetMapping("/holiday")
    public String getHoliday() {
        return "get holiday";
    }

    @PostMapping("/holiday")
    public String postHoliday() {
        return "post holiday";
    }

    @GetMapping("/main")
    public String main() {
        return "main.html";
    }
}
