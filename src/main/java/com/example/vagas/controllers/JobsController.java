package com.example.vagas.controllers;

import com.example.vagas.dtos.JobsDTO;
import com.example.vagas.repository.IJobsRepository;
import com.example.vagas.services.JobsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobsController {

    @Autowired
    private IJobsRepository iJobsRepository;

    @Autowired
    private JobsServices jobsServices;


}
