//package com.study.security3.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
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
//public class ProjectConfigD extends WebSecurityConfigurerAdapter {
//
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        // 임의의 유저 직접 만들기
//        UserDetails user1 =
//                User.withUsername("휴일")
//                .password("12345")
//                        // roles 는 ROLE_ 제외
//                .roles("ADMIN")
//                .build();
//        UserDetails user2 =
//                User.withUsername("우성")
//                .password("12345")
//                        // roles 는 ROLE_ 제외
//                .roles("MANAGER")
//                .build();
//
//        // userDetailsService 로 추가 및 관리
//        userDetailsManager.createUser(user1);
//        userDetailsManager.createUser(user2);
//
//        return userDetailsManager;
//    }
//
//    // 유저 서비스 만들었으니 패스워드 인코더도 추가하자
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    /**
//     * mvcMatchers()
//     * 특정 역할의 사용자에게만
//     * 특정 엔드포인트를 노출할 수 있게 한다
//     */
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.httpBasic()
////
////                .and()
////                .authorizeRequests()
////                // GET 방식 /a 요청은 인증 필수
////                .mvcMatchers(HttpMethod.GET, "/a")
////                .authenticated()
////                // POST 방식 /a 요청은 모두 허용
////                .mvcMatchers(HttpMethod.POST, "/a")
////                .permitAll()
////                .anyRequest().denyAll(); //다른 경로는 요청은 다 거부!
////
////        // GET 요청 말고 다른 HTTP 메서드를 사용하려면
////        // csrf 비활성화 시켜야함
////        http.csrf().disable();
////    }
//
//    /**
//     * mvcMatchers()
//     * 특정 역할의 사용자에게만
//     * 특정 엔드포인트를 노출할 수 있게 한다
//     */
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.httpBasic()
////
////                .and()
////                .authorizeRequests()
////                // /a/b/** 경로는 모두 인증해야함(http 메서드 상관 노노)
////                // /a/**/c 라면,
////                // /a로 시작해서 /c 로 끝나는 경로 전부를 얘기함
////                .mvcMatchers("/a/b/**")
////                .authenticated()
////                .anyRequest().permitAll(); //다른 경로는 요청은 다 허용!
////
////        // GET 요청 말고 다른 HTTP 메서드를 사용하려면
////        // csrf 비활성화 시켜야함
////        http.csrf().disable();
////    }
//
//    /**
//     * 숫자가 포함된 호출만 허용
//     * 나머지는 다 거절
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()
//
//                .and()
//                .authorizeRequests()
//                .mvcMatchers("/product/{code:^[0-9]*$") //길이 관계없이 숫자를 포함하는 문자열을 나타내는 정규식
//                .permitAll()
//                .anyRequest().denyAll(); //다른 경로는 요청은 다 불허!
//
//        // GET 요청 말고 다른 HTTP 메서드를 사용하려면
//        // csrf 비활성화 시켜야함
//        http.csrf().disable();
//    }
//}
