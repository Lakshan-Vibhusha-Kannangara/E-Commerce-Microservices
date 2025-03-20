package com.vibhusha.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String exception){
        super(exception);
    }
}
