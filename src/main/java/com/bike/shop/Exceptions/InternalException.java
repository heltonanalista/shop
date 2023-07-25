package com.bike.shop.Exceptions;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class InternalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<Error> MethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<Error> errorList = new ArrayList<>();
        List<FieldError> fieldError = ex.getBindingResult().getFieldErrors();
        fieldError.forEach(errors -> errorList.add(new Error(errors.getField(), errors.getDefaultMessage())));
        return errorList;
    }
    @ExceptionHandler(NoSuchElementException.class)
    public String NoSuchElementException(NoSuchElementException ex) {
        String message="id not found";
   return  message;
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public String DataIntegrityViolationException(DataIntegrityViolationException ex){
        String message="can not be removed because is in use";
        return message;



    }
}