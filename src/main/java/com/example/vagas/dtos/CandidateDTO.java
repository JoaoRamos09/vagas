package com.example.vagas.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record CandidateDTO(
        @NotBlank(message = "Não é permitido que esteja em branco/vazio")
        String name,

        @NotNull(message = "Não é permitido que esteja vazio")
        Double salary_estimate,
@org.hibernate.validator.constraints.br.CPF
        String CPF)


{


}
