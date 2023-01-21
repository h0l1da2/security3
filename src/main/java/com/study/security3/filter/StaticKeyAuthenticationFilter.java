package com.study.security3.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 속성 파일에서 정적 키값을 읽어 (application.properties)
 * Authorization 헤더 값과 같은지 확인하고
 * 같지 않으면 HTTP 상태코드 401 응답 없음으로 설정
 */
@Component // 속성 파일에서 값을 주입할 수 있도록 스프링이 관리해줘잉~
public class StaticKeyAuthenticationFilter implements Filter {

    // application.properties 에 키 값 추가해야함
    @Value("${authorization.key}")
    private String authorizationKey;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String authentication = httpRequest.getHeader("Authorization");

        if (authorizationKey.equals(authentication)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
