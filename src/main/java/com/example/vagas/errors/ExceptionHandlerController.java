package com.example.vagas.errors;

import com.example.vagas.dtos.ExceptionDTO;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionDTO> userNotFound(NoSuchElementException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("ID não foi encontrado","400");
        return ResponseEntity.badRequest().body(exceptionDTO);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDTO> invalidCPF(ConstraintViolationException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("CPF inválido","400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> duplicateUser(DataIntegrityViolationException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("CPF já cadastrado","400");
    return ResponseEntity.badRequest().body(exceptionDTO);
}

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionDTO> userNotFound(MethodArgumentTypeMismatchException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("ID não foi encontrado","400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ExceptionDTO> userNotFound(BadCredentialsException e){
        ExceptionDTO exceptionDTO = new ExceptionDTO("O usuario não está registrado", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

}
