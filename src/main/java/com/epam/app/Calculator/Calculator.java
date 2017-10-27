package com.epam.app.Calculator;

;

import java.util.*;

/**
 * Created by Iana_Kasimova on 10/26/2017.
 */

public class Calculator {

    PolishNotationAlgorithm algorithm;

    public Calculator(PolishNotationAlgorithm algorithm){
        this.algorithm = algorithm;
    }

    public double calculate(String input) throws Exception{
        StringTokenizer st = new StringTokenizer(algorithm.algorithm(input).toString());
        double number1 = 0, number2 = 0;
        String sTmp;
        Deque<Double> stack = new ArrayDeque<Double>();
        while(st.hasMoreTokens()) {
            try {
                sTmp = st.nextToken().trim();
                if (1 == sTmp.length() && algorithm.isOperator(sTmp.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new Exception("Invalid amount of data in the stack for the operation " + sTmp);
                    }
                    number2 = stack.pop();
                    number1 = stack.pop();
                    switch (sTmp.charAt(0)) {
                        case '+':
                            number1 += number2;
                            break;
                        case '-':
                            number1 -= number2;
                            break;
                        case '/':
                            number1 /= number2;
                            break;
                        case '*':
                            number1 *= number2;
                            break;
                        case '%':
                            number1 %= number2;
                            break;
                        case '^':
                            number1 = Math.pow(number1, number2);
                            break;
                        default:
                            throw new Exception("no correct operation " + sTmp);
                    }
                    stack.push(number1);
                } else {
                    number1 = Double.parseDouble(sTmp);
                    stack.push(number1);
                }
            } catch (Exception e) {
                throw new Exception("incorrect symbol");
            }
        }

        if (stack.size() > 1) {
            throw new Exception("The number of operators does not match the number of operands");
        }
        return stack.pop();
        }

    //Check that in expression there is no incorrect symbols and operators in the end of expression and operators by operators also check that brackets is correct
    public void validation(String input) throws Exception{
            if(!isCorrectBrackets(input))
                throw new Exception();
            if(algorithm.isOperator(input.charAt(input.length()-1)))
                throw new Exception();
            for(int i = 0; i<input.length(); i++){
                if(!(Character.isDigit(input.charAt(i)) || algorithm.isOperator(input.charAt(i))))
                    throw new Exception();
                if((i == input.length()-2) && algorithm.isOperator(input.charAt(i)) && algorithm.isOperator(input.charAt(i+1)))
                    throw new Exception();
            }
            if(algorithm.isOperator(input.charAt(input.length()-1)) || algorithm.isOperator(input.charAt(0))){
            throw new Exception();
        }
    }

    public boolean isCorrectBrackets(String input){
        StringBuilder brackets = new StringBuilder();
        for(int i = 0; i<input.length(); i++){
            if(input.charAt(i) == '(' || input.charAt(i) == ')'){
                brackets.append(input.charAt(i));
            }
        }
        if(brackets.length()==0){
            return true;
        }
        if (brackets.charAt(0) == ')') {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();

        char c;
        for(int i=0; i < brackets.length(); i++) {
            c = brackets.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.empty()) {
                    return false;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
