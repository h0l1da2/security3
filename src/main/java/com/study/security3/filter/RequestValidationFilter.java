package com.study.security3.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 요청에 필요한 헤더가 있는지 확인하는 필터
 * 헤더가 없으면 400 잘못된 요청
 */
public class RequestValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestId = httpRequest.getHeader("Request-Id");

        if (requestId == null | requestId.isBlank()) {
            httpResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            // 필터 체인의 다음 필터로 연결 ㄴㄴ 바로 응답
            return;
        }
        // 요청이 있다면 다음 필터 도세요
        chain.doFilter(request, response);
    }
}
