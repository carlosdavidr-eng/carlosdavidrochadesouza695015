package br.gov.mt.backend.carlosdavidrochadesouza695015.controller;

import br.gov.mt.backend.carlosdavidrochadesouza695015.dto.LoginRequest;
import br.gov.mt.backend.carlosdavidrochadesouza695015.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Para o teste do edital, aceitaremos qualquer usuário/senha 
        // para gerar o token de 5 minutos e demonstrar a tecnologia
        String token = jwtService.generateToken(request.getUsername());
        
        return ResponseEntity.ok(Map.of(
            "access_token", token,
            "token_type", "Bearer",
            "expires_in", "300s" // 5 minutos exigidos no edital
        ));
    }
}