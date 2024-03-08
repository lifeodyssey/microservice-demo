package com.example.bffsvc.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class AuthConfig {
    @Bean
    fun springSecurityFilterChain(serverHttpSecurity: ServerHttpSecurity): SecurityWebFilterChain {
        serverHttpSecurity
            .csrf { it.disable() }
            .authorizeExchange { exchange ->
                exchange.pathMatchers("/eureka/**").permitAll()
                exchange.anyExchange().authenticated()
            }
            .oauth2ResourceServer { it.jwt(Customizer.withDefaults()) }
        return serverHttpSecurity.build()
    }
}