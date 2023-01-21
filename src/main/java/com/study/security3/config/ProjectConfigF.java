package com.study.security3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfigF extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        // 임의의 유저 직접 만들기
        UserDetails user1 =
                User.withUsername("휴일")
                .password("12345")
                .authorities("read")
                .build();
        UserDetails user2 =
                User.withUsername("우성")
                .password("12345")
                .authorities("read", "premium")
                .build();

        // userDetailsService 로 추가 및 관리
        userDetailsManager.createUser(user1);
        userDetailsManager.createUser(user2);

        return userDetailsManager;
    }

    // 유저 서비스 만들었으니 패스워드 인코더도 추가하자
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()

                .and()
                .authorizeRequests()
                // 경로 조건으로 정규식 이용
                // / us,uk,ca /en,fr 는 인증
                .regexMatchers(".*/(us|uk|ca)+/(en|fr).*")
                .authenticated()
                .anyRequest()
                .hasAuthority("premium"); //다른 요청은 프리미엄 권한이어야 가능
    }
}
