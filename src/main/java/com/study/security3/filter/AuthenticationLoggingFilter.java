package com.study.security3.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * BasicAuthenticationFilter 뒤에 동작하는,
 * 인증 필터를 통과했다고 기록하는 필터
 */
public class AuthenticationLoggingFilter implements Filter {

    private final Logger logger =
            Logger.getLogger(
                    AuthenticationLoggingFilter.class.getName()
            );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestId = httpRequest.getHeader("Request-Id");

        // 이 필터를 통과했다는 것을 로그 찍어줌
        logger.info("Successfully authenticated request with id "+requestId);

        chain.doFilter(request, response);
    }
}
