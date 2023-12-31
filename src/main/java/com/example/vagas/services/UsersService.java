package com.example.vagas.services;

import com.example.vagas.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username){
       UserDetails userFindByUsername = usersRepository.findByEmail(username);
       if (userFindByUsername == null){
           throw new UsernameNotFoundException("");
       }
       return userFindByUsername;
    }
}
