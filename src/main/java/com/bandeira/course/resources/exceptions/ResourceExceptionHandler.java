package com.bandeira.course.resources.exceptions;

import com.bandeira.course.services.exceptions.DatabaseException;
import com.bandeira.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError>ResourceNotFound( ResourceNotFoundException exception, HttpServletRequest request ){
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(),status.value(),error,exception.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
    @ExceptionHandler(DatabaseException.class)
    public  ResponseEntity<StandardError>DatabaseException(DatabaseException exception, HttpServletRequest request){
        String error = "database Error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(Instant.now(),status.value(),error,exception.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
