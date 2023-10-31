package com.example.vagas.controllers;

import com.example.vagas.models.Candidate;
import com.example.vagas.models.ICandidateRepository;
import com.example.vagas.models.RequestCandidate;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private ICandidateRepository candidateRepository;

    @PostMapping("/")
    public ResponseEntity<String> createNewCandidate(@RequestBody @Valid RequestCandidate requestCandidate){
        Candidate newCandidate = new Candidate(requestCandidate);
       candidateRepository.save(newCandidate);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateCandidate(@RequestBody @Valid RequestCandidate requestCandidate, @PathVariable UUID id){
        Optional<Candidate> newCandidate = candidateRepository.findById(id);
        if (newCandidate.isPresent()){
            Candidate candidateSave = newCandidate.get();
            candidateSave.setName(requestCandidate.name());
            candidateSave.setSalary_estimate(requestCandidate.salary_estimate());
            return ResponseEntity.ok(candidateSave);
       }
        return ResponseEntity.badRequest().build();
    }
}
