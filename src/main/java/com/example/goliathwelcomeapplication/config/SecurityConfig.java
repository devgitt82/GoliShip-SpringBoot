package com.example.goliathwelcomeapplication.config;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.accept.HeaderContentNegotiationStrategy;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());

        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("api/crew/secure/**",
                                                  "api/comments/secure/**",
                                                  "api/messages/secure/**",
                                                  "api/admin/secure/**").authenticated()
                        .requestMatchers("api/**").permitAll());
        http
                .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer ->
                        httpSecurityOAuth2ResourceServerConfigurer
                                .jwt(jwtConfigurer ->
                                        jwtConfigurer
                                                .jwkSetUri("https://dev-88243632.okta.com/oauth2/default/v1/keys")));

        Okta.configureResourceServer401ResponseBody(http);

        http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

        http.cors(Customizer.withDefaults());

        return http.build();
    }
}
