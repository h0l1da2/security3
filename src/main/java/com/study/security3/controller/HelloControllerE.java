package com.study.security3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * csrf 공격을 막는(사용자 위조 요청)
 * csrf 설정을 해봅시다
 */
@RestController
public class HelloControllerE {

    @GetMapping("/holiday")
    public String getHoliday() {
        return "get holiday";
    }

    @PostMapping("/holiday")
    public String postHoliday() {
        return "post holiday";
    }
}
