package br.gov.mt.backend.carlosdavidrochadesouza695015.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable()) // Desativado para APIs REST
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Sem estado (JWT)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll() // Caso use H2 para testes
                .requestMatchers("/actuator/**").permitAll()   // Health Checks exigidos no edital
                .requestMatchers("/api/v1/auth/**").permitAll() // Endpoint de login (vamos criar)
                .anyRequest().authenticated()                  // Todo o resto exige o Token JWT
            )
            .build();
    }
}