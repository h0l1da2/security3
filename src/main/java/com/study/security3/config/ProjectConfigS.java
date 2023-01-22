package com.study.security3.config;


import com.study.security3.repository.CustomerTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

/**
 * cors 매커니즘에만 집중 가능하게
 * csrf 보호 비활성화
 */
@Configuration
public class ProjectConfigS extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .anyRequest().permitAll();
    }
}
