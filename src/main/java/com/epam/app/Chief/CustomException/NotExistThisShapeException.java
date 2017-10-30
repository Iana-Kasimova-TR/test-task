package com.epam.app.Chief.CustomException;

/**
 * Created by Iana_Kasimova on 10/30/2017.
 */
public class NotExistThisShapeException extends RuntimeException {


    public NotExistThisShapeException(String message) {
        super(message);
    }
}
