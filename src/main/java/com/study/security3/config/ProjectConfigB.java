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
public class ProjectConfigB extends WebSecurityConfigurerAdapter {

    /**
     * (DB)역할 이름은
     * ROLE_ 로 시작해야 한다
     * 그래야 시큐리티가
     * 역할이라고 알아듣는다
     */
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        // 임의의 유저 직접 만들기
//        UserDetails user1 =
//                User.withUsername("휴일")
//                .password("12345")
//                .authorities("ROLE_ADMIN")
//                .build();
//        UserDetails user2 =
//                User.withUsername("우성")
//                .password("12345")
//                .authorities("ROLE_MANAGER")
//                .build();
//
//        // userDetailsService 로 추가 및 관리
//        userDetailsManager.createUser(user1);
//        userDetailsManager.createUser(user2);
//
//        return userDetailsManager;
//    }

    /**
     * (DB)역할 이름은
     * ROLE_ 로 시작해야 한다
     * 그래야 시큐리티가
     * 역할이라고 알아듣는다
     */
    /**
     * User 빌더로 유저를 만든다면 ?
     * roles() 로 역할을 지정한다(ROLE_ 빼고 써야됨) -> 안빼면 예외
     * authorities() -> ROLE_ 붙이기
     * roles() -> ROLE_ 빼기
     */
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
     * 접근 가능 역할 설정할 때는
     * ROLE_ 은 빼야됨(DB 에만 ROLE_ 이다)
     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                // ADMIN 역할만 접근 가능
//                .hasRole("ADMIN");
//    }

    /**
     * denyAll()
     * 모든 사용자 접근 불가
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .denyAll(); // 모든 사용자 접근 불가
    }
}
