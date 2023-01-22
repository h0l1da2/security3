package com.study.security3.config;


import com.study.security3.filter.CsrfTokenLogger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

@Configuration
public class ProjectConfigI extends WebSecurityConfigurerAdapter {

    /**
     * HTTP GET 으로 일단 요청해서
     * csrf 토큰을 얻은 후
     * POST 요청을 해서
     * 토큰 인증 후 입장 가능
     */
    /**
     * CsrfTokenRepository 의 기본 구현은
     * CSRF 토큰의 값을 세션에 저장함
     * 그래서 세션 id 도 있어야함
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new CsrfTokenLogger(), CsrfFilter.class)
                .authorizeRequests()
                .anyRequest().permitAll();
    }
}
