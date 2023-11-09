package com.example.vagas.controllers;

import com.example.vagas.dtos.AuthenticationDTO;
import com.example.vagas.dtos.RegisterDTO;
import com.example.vagas.dtos.TokenDTO;
import com.example.vagas.models.Users;
import com.example.vagas.repository.UsersRepository;
import com.example.vagas.services.TokenServices;
import jakarta.validation.Valid;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsersAuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenServices tokenServices;

    @Autowired
    private UsersRepository usersRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        UsernamePasswordAuthenticationToken username = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        Authentication authenticate = this.authenticationManager.authenticate(username);
        String token = tokenServices.generateToken((Users) authenticate.getPrincipal());
        return ResponseEntity.ok().body(token);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        if (usersRepository.findByEmail(data.username()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Users users = new Users(data.username(), encryptedPassword, data.role());
        usersRepository.save(users);
        return ResponseEntity.ok().body("Criado com sucesso");

    }
    @PostMapping("/validation")
    public ResponseEntity validationtoken(@RequestBody TokenDTO tokenDTO){
        String username = tokenServices.validateToken(tokenDTO.token());
        return ResponseEntity.ok().body(username);
    }
}
