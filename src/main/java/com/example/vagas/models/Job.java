package com.example.vagas.models;

import com.example.vagas.dtos.JobsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity(name = "tb_job")
@AllArgsConstructor
@NoArgsConstructor

public class Job {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String title;

    private String description;

    private Double salary;

    public Job(JobsDTO jobsDTO){
        this.title = jobsDTO.title();
        this.description = jobsDTO.description();
        this.salary = jobsDTO.salary();
    }
}

