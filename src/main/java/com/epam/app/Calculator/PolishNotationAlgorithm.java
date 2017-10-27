package com.epam.app.Calculator;

/**
 * Created by Iana_Kasimova on 10/26/2017.
 */
public class PolishNotationAlgorithm {

    protected StringBuilder algorithm(String input) throws Exception{
        StringBuilder operationStack = new StringBuilder("");
        StringBuilder arrayOfOut = new StringBuilder("");
        char symbol, symbolInStack;

        for (int i = 0; i < input.length(); i++) {
            symbol = input.charAt(i);

            if (isOperator(symbol)) {
                while (operationStack.length() > 0) {
                    symbolInStack = operationStack.substring(operationStack.length()-1).charAt(0);
                    if (isOperator(symbolInStack) && (opPrior(symbol) <= opPrior(symbolInStack))) {
                        arrayOfOut.append(" ").append(symbolInStack).append(" ");
                        operationStack.setLength(operationStack.length()-1);
                    } else {
                        arrayOfOut.append(" ");
                        break;
                    }
                }
                arrayOfOut.append(" ");
                operationStack.append(symbol);
            } else if ('(' == symbol) {
                operationStack.append(symbol);
            } else if (')' == symbol) {
                symbolInStack = operationStack.substring(operationStack.length()-1).charAt(0);
                while ('(' != symbolInStack) {
                    if (operationStack.length() < 1) {
                        throw new Exception("Parse error occurred. Check the correctness of the expression.");
                    }
                    arrayOfOut.append(" ").append(symbolInStack);
                    operationStack.setLength(operationStack.length()-1);
                    symbolInStack = operationStack.substring(operationStack.length()-1).charAt(0);
                }
                operationStack.setLength(operationStack.length()-1);
            } else {
                // If the character is not an operator, add it to the output sequence
                arrayOfOut.append(symbol);
            }
        }

        // If there are operators left on the stack, we add them to the input line
        while (operationStack.length() > 0) {
            arrayOfOut.append(" ").append(operationStack.substring(operationStack.length()-1));
            operationStack.setLength(operationStack.length()-1);
        }

        return  arrayOfOut;
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

    private static byte opPrior(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
        }
        return 1;
    }
}
