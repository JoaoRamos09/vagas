package com.example.vagas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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

    private Double salary_estimate;

    public Candidate(RequestCandidate requestCandidate){
        this.name = requestCandidate.name();
        this.salary_estimate = requestCandidate.salary_estimate();
    }

}
