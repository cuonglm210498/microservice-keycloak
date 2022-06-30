//package com.lecuong.userservice.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.security.oauth2.jwt.JwtDecoder;
//import org.springframework.security.oauth2.jwt.JwtDecoders;
//import org.springframework.security.oauth2.jwt.MappedJwtClaimSetConverter;
//import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
//
//import java.util.Collections;
//import java.util.Map;
//
///**
// * author CuongLM
// */
//@Configuration
//public class JwtDecodeIssuerUriConfig {
//
//    private final String issuerUri = "http://localhost:8080/auth/realms/VSS";
//
//    @Bean
//    public JwtDecoder jwtDecoderByIssuerUri() {
//        NimbusJwtDecoder jwtDecoder = (NimbusJwtDecoder) JwtDecoders.fromIssuerLocation(issuerUri);
//        jwtDecoder.setClaimSetConverter(new UsernameSubClaimAdapter());
//        return jwtDecoder;
//    }
//
//    class UsernameSubClaimAdapter implements Converter<Map<String, Object>, Map<String, Object>> {
//
//        private final MappedJwtClaimSetConverter delegate = MappedJwtClaimSetConverter.withDefaults(Collections.emptyMap());
//
//        @Override
//        public Map<String, Object> convert(Map<String, Object> claims) {
//            Map<String, Object> convertedClaims = this.delegate.convert(claims);
//            String username = (String) convertedClaims.get("preferred_username");
//            convertedClaims.put("sub", username);
//            return convertedClaims;
//        }
//
//    }
//}
