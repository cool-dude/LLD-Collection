package com.flipkart.elections.exceptions;
/*Country Election System */
public class CandidateDuplicateEntryException extends Exception {

    public CandidateDuplicateEntryException( String message){
        super(message);
    }
}
