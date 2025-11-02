package com.ventas.ventas.exception;

import java.net.http.HttpResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
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

@Override
/** implementamos y sobreescribimos */
protected ResponseEntity<Object> handleMethodArgumentNotValid(
    MethodArgumentNotValidException ex, 
    HttpHeaders headers, 
    HttpStatusCode status, 
    WebRequest request
    ) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((e)  ->  {
                String fieldName = ((FieldError) e).getField();
                                String errorMessage = e.getDefaultMessage();

                errors.put(fieldName, errorMessage);
            });
            
            ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                "Ocurrió un error",
                ex.getMessage(),
                errors
            );
    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
}

    

}
