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
public class ProjectConfigE extends WebSecurityConfigurerAdapter {


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

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()
//
//                .and()
//                .authorizeRequests()
//                /**
//                 * mvcMatchers("/hi") 는
//                 * /hi , /hi/ 경로에 전부 인증 필요
//                 * (Controller 와 동일하게 경로 매핑 됨)
//                 */
//                .mvcMatchers("/hi")
//                .authenticated();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()

                .and()
                .authorizeRequests()
                /**
                 * antMatchers("/hi") 는
                 * /hi 경로에는 인증 필요하지만
                 * /hi/ 경로에는 인증 불필요
                 */
                .antMatchers("/hi")
                .authenticated();
    }
}
