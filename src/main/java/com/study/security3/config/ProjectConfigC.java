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
public class ProjectConfigC extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        // 임의의 유저 직접 만들기
        UserDetails user1 =
                User.withUsername("휴일")
                .password("12345")
                        // roles 는 ROLE_ 제외
                .roles("ADMIN")
                .build();
        UserDetails user2 =
                User.withUsername("우성")
                .password("12345")
                        // roles 는 ROLE_ 제외
                .roles("MANAGER")
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

    /**
     * mvcMatchers()
     * 특정 역할의 사용자에게만
     * 특정 엔드포인트를 노출할 수 있게 한다
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                /**
                 * /hello -> ADMIN 역할에게만 보임
                 * /ciao -> MANAGER 역할에게만 보임
                 * 역할이 다르면 403(접근 금지) 에러 발생
                 */
                .mvcMatchers("/hello").hasRole("ADMIN")
                .mvcMatchers("/ciao").hasRole("MANAGER")
//                .anyRequest().permitAll(); //다른 건 역할 상관 ㄴㄴ 다 접근 허용~
                .anyRequest().authenticated(); //다른 것들은 전부 인증된 사용자만 접근 허용~
    }
}
