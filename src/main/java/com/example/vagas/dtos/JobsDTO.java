package com.example.vagas.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record JobsDTO(
        @NotBlank
        String title,
        @NotBlank
        String description,

        @NotNull
        Double salary) {
}
