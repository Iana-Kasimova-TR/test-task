package com.epam.app.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Stack;

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
            if(!isCorrectBrackets(input))
                throw new Exception();
            if(algorithm.isOperator(input.charAt(input.length()-1)))
                throw new Exception();
            for(int i = 0; i<input.length(); i++){
                if(!(Character.isDigit(input.charAt(i)) || algorithm.isOperator(input.charAt(i))))
                    throw new Exception();
                if(algorithm.isOperator(input.charAt(i)) && algorithm.isOperator(input.charAt(i+1))){
                    
                }
            }

    }

    public boolean isCorrectBrackets(String input){
        StringBuilder brackets = new StringBuilder();
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == '(' || input.charAt(i) == ')'){
                brackets.append(input.charAt(i));
            }
        }
        if (brackets.charAt(0) == ')')
            return false;

        Stack<Character> stack = new Stack<Character>();

        char c;
        for(int i=0; i < brackets.length(); i++) {
            c = brackets.charAt(i);

            if(c == '(')
                stack.push(c);
            else if(c == ')')
                if(stack.empty())
                    return false;
                else if(stack.peek() == '(')
                    stack.pop();
                else
                    return false;
        }
        return stack.empty();
    }
}
