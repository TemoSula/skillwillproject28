package com.example.skillwillproject28.Configurations;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, @Qualifier("CustomAuthFilter")OncePerRequestFilter myFilter) throws Exception {
        return http.csrf(custom->custom.disable())
                .addFilterBefore(myFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(custom->custom.requestMatchers("/login","/whoamI","/registration","/swagger-ui/**",
                        "/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui.html", "/webjars/**").permitAll().anyRequest().authenticated())
                .build();
    }


    @Bean
    BCryptPasswordEncoder passwordEncoder()
    {
        return  new BCryptPasswordEncoder();
    }
}
