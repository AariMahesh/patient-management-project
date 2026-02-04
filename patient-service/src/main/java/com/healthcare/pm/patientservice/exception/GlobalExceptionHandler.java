package com.healthcare.pm.patientservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        HashMap<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
    @ExceptionHandler(EmailAlreadyExists.class)
    public ResponseEntity<String> emailAlreadyExists(EmailAlreadyExists exception) {
        log.warn(exception.getMessage());
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
    @ExceptionHandler(PatientNotFoundException.class)
    public ResponseEntity<String> patientNotFoundException(PatientNotFoundException exception) {
        log.warn(exception.getMessage());
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
