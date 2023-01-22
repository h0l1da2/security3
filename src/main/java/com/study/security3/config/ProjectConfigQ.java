//package com.study.security3.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration
//public class ProjectConfigQ extends WebSecurityConfigurerAdapter {
//
//    /**
//     * HTTP GET 으로 일단 요청해서
//     * csrf 토큰을 얻은 후
//     * POST 요청을 해서
//     * 토큰 인증 후 입장 가능
//     */
//    /**
//     * CsrfTokenRepository 의 기본 구현은
//     * CSRF 토큰의 값을 세션에 저장함
//     * 그래서 세션 id 도 있어야함
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        // /like 는 csrf 보안 미적용
//        http.csrf(c -> {
//            c.ignoringAntMatchers("/like");
//        });
//        http.authorizeRequests()
//                .anyRequest().permitAll();
//    }
//}
