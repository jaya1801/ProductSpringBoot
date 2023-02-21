package com.demo.Product;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductRestControllerAdvice {

    @ExceptionHandler(ProductException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleProductException(ProductException e){

        return e.getMessage();
    }
}
