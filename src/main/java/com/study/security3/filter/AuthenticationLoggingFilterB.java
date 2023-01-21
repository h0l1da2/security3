package com.study.security3.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * BasicAuthenticationFilter 뒤에 동작하는,
 * 인증 필터를 통과했다고 기록하는 필터
 */

/**
 * OncePerRequestFilter 는
 * doFilter() 메서드가
 * 요청당 한 번만 실행되도록 보장한다
 * -
 * 그래서 OncePerRequestFilter 를 구현한 해당 필터는
 * 두 번 이상 호출되지 않는다
 */
public class AuthenticationLoggingFilterB extends OncePerRequestFilter {

    /**
     * OncePerRequestFilter 는
     * HTTP 요청만 지원해서
     * HttpServletRequest 로 바로 받을 수 있음
     * (형변환 필요 ㄴㄴ)
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestId = request.getHeader("Request-Id");

        // 이 필터를 통과했다는 것을 로그 찍어줌
        logger.info("Successfully authenticated request with id "+requestId);

        filterChain.doFilter(request, response);
    }
}
