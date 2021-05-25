package com.mike.exception;

public class BasketException extends Exception {
private String message;

    public BasketException(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    public BasketException setMessage(String message) {
        this.message = message;
        return this;
    }
    
    public String printCause() {
        System.out.println(message);
        return message;
    }
}
