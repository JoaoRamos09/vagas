package com.example.vagas.repository;

import com.example.vagas.models.UserRole;
import com.example.vagas.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
    public UserDetails findByEmail(String user);
}
