package com.example.vagas.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "tb_job")
public class Job {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String title;

    private String description;

    private Double salary;

}

