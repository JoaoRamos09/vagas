package com.example.vagas.services;

import com.example.vagas.models.Candidate;
import com.example.vagas.models.Job;
import com.example.vagas.repository.ICandidateRepository;
import com.example.vagas.repository.IJobsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public class JobsServices {
    @Autowired
    private IJobsRepository iJobsRepository;
    @Autowired
    private ICandidateRepository iCandidateRepository;

    public void createNewJob(Job job){
        this.iJobsRepository.save(job);
    }

    public List<Job> filterJobsByCandidateSalary(List<Job> jobList, UUID uuid) throws Exception {
        Optional<Candidate> optionalCandidate = this.iCandidateRepository.findById(uuid);
        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();
            return jobList.stream().filter(job -> job.getSalary() < candidate.getSalary_estimate()).toList();
        }
        throw new Exception("erro no filtro");
    }
}
