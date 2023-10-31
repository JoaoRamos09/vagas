package com.example.vagas.services;

import com.example.vagas.models.Candidate;
import com.example.vagas.models.ICandidateRepository;
import com.example.vagas.models.RequestCandidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateServices {

    @Autowired
    private ICandidateRepository iCandidateRepository;

    public void createNewCandidate(Candidate candidate){
        this.iCandidateRepository.save(candidate);
    }

}
