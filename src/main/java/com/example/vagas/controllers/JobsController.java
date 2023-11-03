package com.example.vagas.controllers;

import com.example.vagas.dtos.JobsDTO;
import com.example.vagas.models.Job;
import com.example.vagas.repository.IJobsRepository;
import com.example.vagas.services.JobsServices;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    @Autowired
    private IJobsRepository iJobsRepository;

    @Autowired
    private JobsServices jobsServices;

    @PostMapping("/")
    public ResponseEntity<String> createNewJob(@Valid @RequestBody JobsDTO jobsDTO) {
        Job jobSave = new Job(jobsDTO);
        jobsServices.createNewJob(jobSave);
        return ResponseEntity.ok().body("Vaga salva com sucesso");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Job> updateJob(@RequestBody @Valid JobsDTO jobsDTO, @PathVariable UUID id){
        Optional<Job> jobById = iJobsRepository.findById(id);
        Job job = jobById.orElseThrow();
        Job newJob = jobsServices.allSetters(job, jobsDTO);
        return ResponseEntity.ok(newJob);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Job>> allJob(){
        List<Job> allJob = iJobsRepository.findAll();
        return ResponseEntity.ok(allJob);
    }
    
    @GetMapping("/jobsbycandidatesalary/{id}")
    public ResponseEntity<List<Job>> allJobFilterByCandidate(@RequestBody @Valid @PathVariable UUID id) throws Exception {
        List<Job> jobsFiltered = jobsServices.filterJobsByCandidateSalary(id);
        return ResponseEntity.ok(jobsFiltered);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJob(@PathVariable UUID id){
        iJobsRepository.deleteById(id);
        return ResponseEntity.ok().body("Usuário deletado com sucesso");
    }
            

}
