package com.study.security3.config;


import com.study.security3.repository.CustomerTokenRepository;
import com.study.security3.repository.JpaTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

@Configuration
public class ProjectConfigR extends WebSecurityConfigurerAdapter {


    // csrfTokenRepository 커스텀하고 내껄로 동작하게 등록
    @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        return new CustomerTokenRepository();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf(c -> {
            // csrf 설정을 커스텀 csrfTokenRepository 를 사용하도록 변경
            c.csrfTokenRepository(csrfTokenRepository());
            // /like 는 csrf 보안 미적용
            c.ignoringAntMatchers("like");
        });
        http.authorizeRequests()
                .anyRequest().permitAll();
    }
}
