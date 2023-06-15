package com.example.goliathwelcomeapplication.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("api/crew/secure/**").authenticated()
                        .requestMatchers("api/**").permitAll()
                )
                .oauth2ResourceServer(oAuth2ResourceServerConfigurer->
                        oAuth2ResourceServerConfigurer.jwt(jwtConfigurer ->
                                jwtConfigurer.jwkSetUri("https://dev-70719039.okta.com/oauth2/default/.well-known/oauth-authorization-server")));

        Okta.configureResourceServer401ResponseBody(http);


        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        http.cors(Customizer.withDefaults());

        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("https://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/crew/secure/**", configuration);
        return source;
    }
}
