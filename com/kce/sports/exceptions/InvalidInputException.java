package com.kce.sports.exceptions;

public class InvalidInputException extends Exception {
    
 
    public InvalidInputException(String message) {
        super(message);
        System.out.println(message); 
    }
}



