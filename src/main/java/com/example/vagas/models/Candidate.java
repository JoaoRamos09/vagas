package com.example.vagas.models;

import com.example.vagas.dtos.CandidateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.UUID;

@Entity(name = "tb_candidate")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    @Column(unique = true)
    @CPF
    private String CPF;

    private Double salary_estimate;

    public Candidate(CandidateDTO requestCandidate){
        this.name = requestCandidate.name();
        this.salary_estimate = requestCandidate.salary_estimate();
        this.CPF = requestCandidate.CPF();
    }

}
