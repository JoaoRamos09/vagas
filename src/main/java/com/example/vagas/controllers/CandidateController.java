package com.example.vagas.controllers;

import com.example.vagas.models.Candidate;
import com.example.vagas.repository.ICandidateRepository;
import com.example.vagas.dtos.CandidateDTO;
import com.example.vagas.services.CandidateServices;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private ICandidateRepository candidateRepository;

    @Autowired
    private CandidateServices candidateServices;

    @PostMapping("/")
    public ResponseEntity<String> createNewCandidate(@RequestBody @Valid CandidateDTO requestCandidate){
        Candidate newCandidate = new Candidate(requestCandidate);
       candidateRepository.save(newCandidate);
        return ResponseEntity.ok().body("Usuário criado com sucesso");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Candidate> updateCandidate(@RequestBody @Valid CandidateDTO candidateDTO, @PathVariable UUID id) throws Exception {
        Optional<Candidate> newCandidate = candidateRepository.findById(id);
        Candidate candidate = newCandidate.orElseThrow();
        candidateServices.allSetters(candidate,candidateDTO);
        return ResponseEntity.ok().body(candidate);
    }

    @GetMapping("/")
    public ResponseEntity<List<Candidate>> allCandidates(){
        List<Candidate> allCandidates = candidateServices.getAllCandidates();
        return ResponseEntity.ok().body(allCandidates);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteCandidate(@RequestBody @Valid UUID uuid){
        candidateRepository.deleteById(uuid);
        return ResponseEntity.ok().body("Usuário deletado com sucesso");
    }
}
