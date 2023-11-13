package com.gabrielprata.cursouml.cursouml.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gabrielprata.cursouml.cursouml.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
    //Notação utilizada para indicar que é um objeto que trata excessões do tipo que esta dentro dele
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        StandartError error = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }
}
