package com.cbfacademy.restapiexercise.core;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IOUNotFoundException.class)
    protected ResponseEntity<ApiErrorResponse> handleIOUNotFoundException(IOUNotFoundException ex) {
        ApiErrorResponse exceptionResponse = new ApiErrorResponse();
        exceptionResponse.setMessage(ex.getMessage());
        return new ResponseEntity(exceptionResponse, ResponseEntity.notFound().build().getStatusCode());

    }

}