package com.example.skillwillproject28.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {


    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ExceptionBody> handleGeneralException(GeneralException ge)
    {
        ExceptionBody eb = new ExceptionBody();
        eb.setMessage(ge.getMessage());
        eb.setHttpStatus(ResponseEntity.status(HttpStatus.NOT_FOUND).build().getStatusCode());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(eb);
    }
}
