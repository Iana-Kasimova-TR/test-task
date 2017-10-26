package com.epam.app.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Iana_Kasimova on 10/26/2017.
 */
@Component
public class Calculator {

    @Autowired
    PolishNotationAlgorithm algorithm;

    public double calculate(String input){

        return 0;
    }

    public void validation(String input) throws Exception{

    }
}
