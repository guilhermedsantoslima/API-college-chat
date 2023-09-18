package com.br.cadastro.rest.controller;

import com.br.cadastro.exception.NotFoundUserException;
import com.br.cadastro.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodValidNotException(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toList());

        return new ApiErrors(errors);
    }

    @ExceptionHandler(NotFoundUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleNotFoundUserException(NotFoundUserException e){
        return new ApiErrors(e.getMessage());
    }
}
