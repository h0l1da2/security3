package com.study.security3.filter;

import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * csrf 공격을 방지하기 위해
 * 일단 GET 요청으로 받아서
 * csrf 토큰을 생성하고(uuid로 만드러줌)
 * 그걸 HTTP 요청의 _csrf 특성에 추가해서
 * POST 요청으로 넘기면
 * 토큰을 확인한 후 정상 POST 응답으로 넘겨줌
 */
public class CsrfTokenLogger implements Filter {

    private Logger logger = Logger.getLogger(CsrfTokenLogger.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Object csrf = request.getAttribute("_csrf");
        CsrfToken token = (CsrfToken) csrf;

        logger.info("CSRF token" + token.getToken());
        chain.doFilter(request, response);
    }
}
