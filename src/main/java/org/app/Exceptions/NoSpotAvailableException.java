package org.app.Exceptions;

public class NoSpotAvailableException extends RuntimeException{
    private String message;
    private int httpCode;

    public NoSpotAvailableException(String message){
        super(message);
        this.httpCode = 404;
    }
}
