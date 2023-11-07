package com.example.vagas.repository;

import com.example.vagas.models.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IJobsRepository extends JpaRepository<Jobs, UUID> {
}
