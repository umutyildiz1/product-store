package com.umutyildiz.product_service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(exception = ProductNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public void handleProductNotFoundException(Exception e){
        log.info(e.getMessage());
    }

}
