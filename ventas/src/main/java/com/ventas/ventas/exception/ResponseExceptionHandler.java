package com.ventas.ventas.exception;

import java.net.http.HttpResponse;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    
@ExceptionHandler(Exception.class)
public final ResponseEntity<ExceptionResponse> manejarTodaExcepcion(Exception e) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(
        new Date(),
        "Ocurrió un error",
        e.getMessage()
    );

    return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
}

    

}
