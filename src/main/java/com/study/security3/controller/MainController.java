package com.study.security3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
public class MainController {

    // test() 메서드 호출 시점을 알기 위해 로그 이용
    private Logger logger =
            Logger.getLogger(MainController.class.getName());

    // /test 엔드포인트를 요청하는 main.html 페이지
    @GetMapping("/")
    public String main() {
        return "main2";
    }

    @PostMapping("/test")
    @ResponseBody
    public String test() {
        logger.info("Test method called");
        return "HELLO";
    }
}
