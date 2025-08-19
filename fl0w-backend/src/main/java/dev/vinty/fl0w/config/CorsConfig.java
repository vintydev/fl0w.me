package dev.vinty.fl0w.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {


    @Bean
    public CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration configuration = new CorsConfiguration();

        // Allow requests from React frontend
        configuration.addAllowedOrigin("http://localhost:3000");

        // Allow all HTTP methods (GET, POST, PUT, DELETE, OPTIONS)
        configuration.addAllowedMethod("*");

        // Allow all headers
        configuration.addAllowedHeader("*");

        // Allow credentials (cookies, authorization headers, etc.)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);

        return source;

    }
}
