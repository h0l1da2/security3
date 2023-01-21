//package com.study.security3.config;
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
//public class ProjectConfigA extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
//        // 임의의 유저 직접 만들기
//        UserDetails user1 =
//                User.withUsername("휴일")
//                .password("12345")
//                .authorities("READ")
//                .build();
//        UserDetails user2 =
//                User.withUsername("우성")
//                .password("12345")
//                .authorities("WRITE")
//                .build();
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
//    // 모든 요청에 대한 엑세스를 허용해요 !
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.httpBasic()
////                .and()
////                // 모든 요청에 대한 엑세스 허용
////                .authorizeRequests()
////                .anyRequest().permitAll();
////    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.httpBasic()
////                .and()
////                // WRITE 권한을 가진 사람만 접근 허용(우성이만 가능)
////                .authorizeRequests()
////                .anyRequest()
////                .hasAuthority("WRITE");
////    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.httpBasic()
////                .and()
////                // WRITE 나 READ 권한을 가진 사람만 접근 허용(휴일이도 우성이도 가능)
////                .authorizeRequests()
////                .anyRequest()
////                .hasAnyAuthority("WRITE", "READ");
////    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.httpBasic()
////                .and()
////                // WRITE 권한 있는 사람만 접근 가능
////                // access() 이용
////                .authorizeRequests()
////                .anyRequest()
////                .access("hasAuthority('WRITE')");
////    }
//
//    // 복잡한 조건이라면 !? access 가 좋다
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic()
//                .and()
//                // access() 이용
//                .authorizeRequests()
//                .anyRequest()
//                // 읽기 권한이 있어야하지만 삭제 권한은 없어야 함
//                .access("hasAuthority('WRITE') and !hasAuthority('DELETE')");
//    }
//}
