package com.example.vagas.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "tb_usersbyaplicattion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements UserDetails {


    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Id
    @GeneratedValue(generator = "UUID")

    private UUID id;

    public Users(String username,String password,UserRole userRole){
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.userRole == UserRole.ADMIN) {
            return List.of
                    (new SimpleGrantedAuthority("ROLE_ADM"),new SimpleGrantedAuthority("ROLE_USER"));
        }
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
         return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true ;
    }
}
