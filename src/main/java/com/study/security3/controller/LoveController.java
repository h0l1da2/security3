package com.study.security3.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoveController {

    // csrf 보호 적용
    @PostMapping("/love")
    public String postLove() {
        return "Post Love";
    }

    // csrf 보호 미적용
    @PostMapping("/like")
    public String postLike() {
        return "Post Like";
    }
}
