package com.example.vagas.models;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

public record RequestCandidate(
        @NotBlank(message = "Não é permitido que esteja em branco/vazio")
        String name,

        @NotNull(message = "Não é permitido que esteja vazio")
        Double salary_estimate) {

}
