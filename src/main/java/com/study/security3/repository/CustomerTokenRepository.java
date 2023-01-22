package com.study.security3.repository;

import com.study.security3.domain.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import java.util.UUID;

/**
 * JpaTokenRepository 를 주입해 DB 접근
 * csrf 토큰을 DB에서 얻거나 DB에 저장
 */
public class CustomerTokenRepository implements CsrfTokenRepository {

    @Autowired
    private JpaTokenRepository jpaTokenRepository;

    // 새 토큰 생성
    @Override
    public CsrfToken generateToken(HttpServletRequest request) {
        String uuid = UUID.randomUUID().toString();
        /**
         * X-CSRF-TOKEN : 클라이언트 고유 식별자가 있는 헤더
         * _csrf : 토큰 저장 요청의 특성 이름
         * uuid : 토큰값
         */
        return new DefaultCsrfToken("X-CSRF-TOKEN", "_csrf", uuid);
    }

    // 토큰 저장
    @Override
    public void saveToken(CsrfToken token, HttpServletRequest request, HttpServletResponse response) {
        // 클라이언트 고유 식별자 가져오기
        String identifier = request.getHeader("X-IDENTIFIER");
        // DB에서 식별자 찾기
        Optional<Token> existingToken = jpaTokenRepository.findTokenByIdentifier(identifier);

        // ID 가 존재하면 새로 생성된 값으로 토큰 업데이트
        if (existingToken.isPresent()) {
            Token csrfToken = existingToken.get();
            csrfToken.setToken(token.getToken());
        } else {
            // ID가 없으면 새로운 CSRF 토큰 생성 후 DB넣기
            Token csrfToken = new Token();
            csrfToken.setToken(token.getToken());
            csrfToken.setIdentifier(identifier);
            jpaTokenRepository.save(csrfToken);
        }

    }

    // 토큰 세부정보 가져오기
    @Override
    public CsrfToken loadToken(HttpServletRequest request) {
        String identifier = request.getHeader("X-IDENTIFIER");

        Optional<Token> existingToken = jpaTokenRepository.findTokenByIdentifier(identifier);

        if (existingToken.isPresent()) {
            Token token = existingToken.get();
            return new DefaultCsrfToken(
                    "X-CSRF-TOKEN",
                    "_csrf",
                    token.getToken()
            );
        }
        return null;
    }
}
