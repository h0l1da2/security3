//package com.study.security3.config;
//
//
//import com.study.security3.filter.AuthenticationLoggingFilter;
//import com.study.security3.filter.RequestValidationFilter;
//import com.study.security3.filter.StaticKeyAuthenticationFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//@Configuration
//public class ProjectConfigH extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private StaticKeyAuthenticationFilter filter;
//
//    /**
//     * 기본 인증 필터 위치에 필터 추가
//     * BasicAuthenticationFilter 동작하는 위치에 filter 가 들어감
//     * -
//     * 단, 같은 위치에 필터를 추가하면
//     * 스프링 시큐리티는 필터가 실행되는 순서를 보장하지 않음
//     * 기존 필터 위치에 다른 필터를 적용한다?
//     * 대체가 되는 게 아님, 실행 순서도 보장 안 됨
//     * -> 그냥 하지 않는 게 낫다...?
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//        /**
//         * BasicAuthenticationFilter 은
//         * httpBasic 방식일 때만 동작하는 필터여서
//         * 여기서는 그 자리에 filter 를 넣어도 괜찮지만
//         * 해당 필터가 정상 동작하는데
//         * 그 위치에 내 필터도 추가해버리면
//         * 순서 보장이 안 된다 ...
//         */
//                .addFilterAt(filter, BasicAuthenticationFilter.class)
//                .authorizeRequests()
//                .anyRequest().permitAll();
//    }
//}
