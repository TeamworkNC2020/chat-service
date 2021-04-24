package com.moviesandchill.chatservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // FIXME
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:4200",
                        "https://localhost:4200",
                        "http://localhost:8080",
                        "https://localhost:8080",
                        "https://localhost:8081",
                        "http://mac21-chat.herokuapp.com",
                        "https://mac21-chat.herokuapp.com")
                .allowCredentials(true);
    }
}
