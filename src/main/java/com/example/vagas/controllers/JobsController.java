package com.example.vagas.controllers;

import com.example.vagas.dtos.JobsDTO;
import com.example.vagas.models.Jobs;
import com.example.vagas.repository.IJobsRepository;
import com.example.vagas.services.JobsServices;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        Jobs jobSave = new Jobs(jobsDTO);
        jobsServices.createNewJob(jobSave);
        return ResponseEntity.ok().body("Vaga salva com sucesso");
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Jobs> updateJob(@RequestBody @Valid JobsDTO jobsDTO, @PathVariable UUID id){
        Optional<Jobs> jobById = iJobsRepository.findById(id);
        Jobs job = jobById.orElseThrow();
        Jobs newJob = jobsServices.allSetters(job, jobsDTO);
        return ResponseEntity.ok(newJob);
    }
    
    @GetMapping("/")
    public ResponseEntity<List<Jobs>> allJob(){
        List<Jobs> allJob = iJobsRepository.findAll();
        return ResponseEntity.ok(allJob);
    }
    
    @GetMapping("/jobsbycandidatesalary/{id}")
    public ResponseEntity<List<Jobs>> allJobFilterByCandidate(@RequestBody @Valid @PathVariable UUID id) throws Exception {
        List<Jobs> jobsFiltered = jobsServices.filterJobsByCandidateSalary(id);
        return ResponseEntity.ok(jobsFiltered);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteJob(@PathVariable UUID id){
        iJobsRepository.deleteById(id);
        return ResponseEntity.ok().body("Usuário deletado com sucesso");
    }
            

}
