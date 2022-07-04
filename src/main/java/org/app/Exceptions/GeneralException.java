package org.app.Exceptions;

public class GeneralException extends RuntimeException{
    private String message;
    private int httpCode;

    public GeneralException(String message, int httpCode){
        super(message);
        this.httpCode = httpCode;
    }
}
