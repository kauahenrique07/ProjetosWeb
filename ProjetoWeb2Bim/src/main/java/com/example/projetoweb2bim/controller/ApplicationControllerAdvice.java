package com.example.projetoweb2bim.controller;


import com.example.projetoweb2bim.exceptions.ApiErrorMessage;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {


    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorMessage handleException(Exception ex){
        return new ApiErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorMessage handleArgumentNotValidException(MethodArgumentNotValidException ex){
        ArrayList<String> listaErros = new ArrayList<>();


        for (FieldError error: ex.getBindingResult().getFieldErrors()
             ) {
                 listaErros.add(error.getField() + ": " + error.getDefaultMessage());
        }
        return new ApiErrorMessage(listaErros);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorMessage handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> listaErros = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.toList());
        return new ApiErrorMessage(listaErros);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorMessage handleDataIntegrityViolationException(DataIntegrityViolationException ex){
        // Personalize a mensagem de erro como desejar
        String errorMessage = "Erro: " + ex.getMessage();
        return new ApiErrorMessage(Collections.singletonList(errorMessage));
    }

    }

