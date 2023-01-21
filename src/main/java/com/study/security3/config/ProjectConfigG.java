//package com.study.security3.config;
//
//
//import com.study.security3.filter.AuthenticationLoggingFilter;
//import com.study.security3.filter.RequestValidationFilter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//@Configuration
//public class ProjectConfigG extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                /**
//                 * BasicAuthenticationFilter 가 돌아가기 전에
//                 * RequestValidationFilter 먼저 동작하게 해주세요!
//                 */
//                .addFilterBefore(
//                        new RequestValidationFilter(),
//                        BasicAuthenticationFilter.class)
//                /**
//                 * BasicAuthenticationFilter 가 돌아간 후에
//                 * AuthenticationLoggingFilter 가 동작하게 해주세요
//                 */
//                .addFilterAfter(
//                        new AuthenticationLoggingFilter(),
//                        BasicAuthenticationFilter.class
//                )
//                .authorizeRequests()
//                .anyRequest().permitAll();
//    }
//}
