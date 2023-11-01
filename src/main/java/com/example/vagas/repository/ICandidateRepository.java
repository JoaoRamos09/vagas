package com.example.vagas.repository;

import com.example.vagas.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface ICandidateRepository extends JpaRepository<Candidate,UUID> {
}
