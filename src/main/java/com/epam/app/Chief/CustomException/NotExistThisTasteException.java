package com.epam.app.Chief.CustomException;

/**
 * Created by Iana_Kasimova on 10/30/2017.
 */
public class NotExistThisTasteException extends RuntimeException{
    public NotExistThisTasteException(String message) {
        super(message);
    }
}
