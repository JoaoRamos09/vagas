package com.example.vagas.services;

import com.example.vagas.models.Candidate;
import com.example.vagas.repository.ICandidateRepository;
import com.example.vagas.dtos.CandidateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServices {

    @Autowired
    private ICandidateRepository iCandidateRepository;

    public void createNewCandidate(Candidate candidate){
        this.iCandidateRepository.save(candidate);
    }

    public void allSetters(Candidate candidate, CandidateDTO requestCandidate){
        candidate.setName(requestCandidate.name());
        candidate.setSalary_estimate(requestCandidate.salary_estimate());
        candidate.setCPF(requestCandidate.CPF());
    }

    public List<Candidate> getAllCandidates(){
      return iCandidateRepository.findAll();
    }

}
