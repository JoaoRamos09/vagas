package com.example.vagas.services;

import com.example.vagas.dtos.JobsDTO;
import com.example.vagas.models.Candidate;
import com.example.vagas.models.Jobs;
import com.example.vagas.repository.ICandidateRepository;
import com.example.vagas.repository.IJobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class JobsServices {
    @Autowired
    private IJobsRepository iJobsRepository;
    @Autowired
    private ICandidateRepository iCandidateRepository;

    public void createNewJob(Jobs job){
        this.iJobsRepository.save(job);
    }

    public List<Jobs> filterJobsByCandidateSalary(UUID uuid) throws Exception {
        Optional<Candidate> optionalCandidate = this.iCandidateRepository.findById(uuid);
        List<Jobs> allJobs = iJobsRepository.findAll();
        if (optionalCandidate.isPresent()) {
            Candidate candidate = optionalCandidate.get();
            return allJobs.stream().filter(job -> job.getSalary() > candidate.getSalary_estimate()).toList();
        }
        throw new Exception("erro no filtro");
    }

    public Jobs allSetters(Jobs job, JobsDTO jobsDTO){
        job.setTitle(jobsDTO.title());
        job.setSalary(jobsDTO.salary());
        job.setDescription(jobsDTO.description());
        return job;
    }
}
