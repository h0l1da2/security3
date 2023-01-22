package com.study.security3.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

/**
 * cors 매커니즘에만 집중 가능하게
 * csrf 보호 비활성화
 */
@Configuration
public class ProjectConfigT extends WebSecurityConfigurerAdapter {


    /**
     * cors() -> Customizer<CorsConfigurer> 객체를 매개변수로 받음
     * 그 객체를 위해 HTTP 요청의 CorsConfiguration 을 받는 CorsConfigurationSource 설정했음
     * CorsConfiguration -> 허용되는 출처, 메서드, 헤더 지정하는 객체
     * -
     * 최소 출처와 메서드는 지정해야한다
     * 출처만ㄴ 지정하면 요청 허용 안함
     * CorsConfiguration 가 아무 메서드도 정의하지 않아서 메서드 안쓰면 안 동작함
     * -> 다른 클래스로 지정해서 설정하세요. 여기서 설정하면 넘 복잡함
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors(c -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration config = new CorsConfiguration();
                // 허용되는 교차출처 경로
                config.setAllowedOrigins(
                        List.of("example.com", "example.org")
                );
                // 허용되는 교차출처 메서드
                config.setAllowedMethods(
                        List.of("GET", "POST", "PUT", "DELETE")
                );
                return config;
            };
            c.configurationSource(source);
        });

        http.csrf().disable();

        http.authorizeRequests()
                .anyRequest().permitAll();
    }
}
