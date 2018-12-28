package com.fpa.agsapipluralsight.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(){

    }

    public ProductNotFoundException(String message){
        super(message);
    }

    public ProductNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }

    public ProductNotFoundException(Throwable throwable){
        super(throwable);
    }

    public ProductNotFoundException(Long productId){
        this(String.format("Product [%d] not found. Please certify that the ID is correct and try again.", productId));
    }

}
