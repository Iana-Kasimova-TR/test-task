package com.epam.app.Calculator;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Iana_Kasimova on 10/26/2017.
 */
public class PolishNotationAlgorithm {

    protected StringBuilder algorithm(String input){
        StringBuilder arrayOfOut = new StringBuilder();
        StringBuilder operationStack = new StringBuilder();

        char symbolInArray, symbolInStack, symbol;


        for(int i=0; i<input.length(); i++){
            symbol = input.charAt(i);
            symbolInStack = operationStack.charAt(operationStack.length() - 1);
            if(Character.isDigit(symbol))
            {
                while(Character.isDigit(input.charAt(i+1))) {
                    symbol += input.charAt(i + 1);
                    i++;
                }
                i+=1;
                arrayOfOut.append(symbol);
            }else if(isOperator(symbol))
            {
                while((operationStack.length()>0)){
                    if (isEqualPriority(symbol, symbolInStack)) {
                        arrayOfOut.append(symbolInStack);
                        operationStack = operationStack.deleteCharAt(operationStack.length() - 1);
                        operationStack.append(symbol);
                        break;
                    } else if (symbol == whichMorePriority(symbol, symbolInStack)) {
                        arrayOfOut.append(symbol);
                        break;
                    } else {
                        arrayOfOut.append(symbolInStack);
                        operationStack = operationStack.deleteCharAt(operationStack.length() - 1);
                        operationStack.append(symbol);
                    }
                }
                }else if(symbol == '('){
                        operationStack.append('(');
                }else if(symbol == ')'){
                    char symbolInStackAfterBracket = symbolInStack;
                    while('('!=symbolInStackAfterBracket){
                        arrayOfOut.append(symbolInStackAfterBracket);
                        operationStack.deleteCharAt(operationStack.length()-1);
                        symbolInStackAfterBracket = operationStack.charAt(operationStack.length()-1);
                    }
                operationStack.deleteCharAt(operationStack.length()-1);
            }
            }

                for(int i = operationStack.length()-1; i>0; i--){
                    arrayOfOut.append(operationStack.charAt(i));
                }


                return arrayOfOut;
        }


    protected static boolean isOperator(char c) {
        switch (c) {
            case '-':
            case '+':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }

    private static boolean isEqualPriority(char a, char b){
        if(((a == '+') || (a == '-')) && ((b == '-') || (b == '+'))){
            return true;
        }else if(((a == '*') || (a == '/')) && ((b == '/') || (b == '*'))){
            return true;
        }
        else{
            return false;
        }
    }

    private static char whichMorePriority(char a, char b) {
        char result = ' ';
        if (((a == '+') || (a == '-')) && ((b == '*') || (b == '/'))) {
            result = b;
        } else if (((a == '*') || (a == '/')) && ((b == '+') || (b == '-'))) {
            result = a;
        }

        return result;
    }

}
