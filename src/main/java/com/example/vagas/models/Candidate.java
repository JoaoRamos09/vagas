package com.example.vagas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity(name = "tb_candidate")
@Data
public class Candidate {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    private Double salary_estimate;

}
