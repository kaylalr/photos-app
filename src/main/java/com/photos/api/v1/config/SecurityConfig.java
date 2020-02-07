package com.photos.api.v1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(STATELESS)
                .and()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers("/auth/login").permitAll()
                // todo: don't permit all api requests
                .antMatchers("/api/v1/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()
                .and()
                .csrf().disable();
    }
}
