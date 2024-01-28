package com.flipkart.elections.exceptions;
/*Country Election System */
public class NotExistsException extends Exception {
    public NotExistsException(String message) {
        super("Does not exist" + message);
    }
}
