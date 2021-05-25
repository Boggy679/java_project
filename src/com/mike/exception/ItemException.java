package com.mike.exception;

public class ItemException extends Exception {
    private String message;

    public ItemException(String message) {
        this.message = message;
    }
    
    @Override
    public String getMessage() {
        return message;
    }
    
    public ItemException setMessage(String message) {
        this.message = message;
        return this;
    }
    
    public String printCause() {
        System.out.println(message);
        return message;
    }
}
