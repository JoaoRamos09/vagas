package com.example.vagas.dtos;

import com.example.vagas.models.UserRole;

public record RegisterDTO(String username, String password, UserRole role) {
}
