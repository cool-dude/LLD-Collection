package com.flipkart.elections.exceptions;
/*Country Election System */
public class PartyAlreadyExistsException extends Exception {
    public PartyAlreadyExistsException(String message){
        super(message + "already exists");
    }
}
