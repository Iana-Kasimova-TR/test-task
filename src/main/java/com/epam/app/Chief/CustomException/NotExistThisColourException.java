package com.epam.app.Chief.CustomException;

/**
 * Created by Iana_Kasimova on 10/30/2017.
 */
public class NotExistThisColourException extends RuntimeException {
    public NotExistThisColourException(String message) {
        super(message);
    }
}
