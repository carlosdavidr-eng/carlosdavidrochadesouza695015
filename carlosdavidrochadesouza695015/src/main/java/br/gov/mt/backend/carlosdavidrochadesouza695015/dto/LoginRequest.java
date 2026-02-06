package br.gov.mt.backend.carlosdavidrochadesouza695015.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}