package com.example.surya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.surya.filter.JwtAuthenticationFilter;


@Configuration
public class GatewayConfig {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                // Auth service route - publicly accessible
                .route("userauth-service-route", r -> r.path("/api/auth/**")
                        .uri("lb://USER-AUTHENTICATION-SERVICE"))
                
                // Question service route - requires ADMIN role
                .route("account-service-route", r -> r.path("/api/accounts/**")
                        .filters(f -> {
                            JwtAuthenticationFilter.Config config = new JwtAuthenticationFilter.Config();
                            config.setRequiredRole("ADMIN");
                            return f.filter(jwtAuthenticationFilter.apply(config));
                        })
                        .uri("lb://account-service"))
                
                // Quiz service route - requires either ADMIN or USER role 
                .route("customer-service-route", r -> r.path("/api/customers/**")
                        .filters(f -> {
                            JwtAuthenticationFilter.Config config = new JwtAuthenticationFilter.Config();
                            // We don't set a specific required role here because both USER and ADMIN can access
                            // The filter will check if the user has a valid token
                            return f.filter(jwtAuthenticationFilter.apply(config));
                        })
                        .uri("lb://customer-service"))
                .build();
    }
}