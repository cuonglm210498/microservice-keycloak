package com.lecuong.userservice.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.web.client.RestOperations;

import java.time.Duration;

/**
 * author CuongLM
 */
@Configuration
public class JwtDecodeJwkUriConfig {

    private final String jwkSetUri = "http://localhost:8080/auth/realms/VSS/protocol/openid-connect/certs";

    @Bean
    public RestTemplateBuilder restTemplateBuilder() {
        return new RestTemplateBuilder();
    }

    @Bean
    public JwtDecoder jwtDecoder(RestTemplateBuilder builder) {
        RestOperations rest = builder
                .setConnectTimeout(Duration.ofMinutes(3))
                .setReadTimeout(Duration.ofMinutes(3))
                .build();
        return NimbusJwtDecoder.withJwkSetUri(jwkSetUri).restOperations(rest).build();
    }
}
