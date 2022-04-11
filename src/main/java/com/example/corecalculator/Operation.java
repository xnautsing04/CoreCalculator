package com.example.corecalculator;

import org.mariuszgromada.math.mxparser.*;

public class Operation {

    //This stores the characters of the equation to be used for the operation.
    private String characters;

    //This stores the answer to the equation.
    private String result;

    //The constructor assigns characters to the operators passed.
    public Operation(String operators) {
        characters = operators;
    }

    //This function uses the mxparser library and passes the characters as an expression and stores the calculated answer.
    public void calculateOperation(){
        Expression exp = new Expression(characters);

        result = String.valueOf(exp.calculate());
    }

    //This function returns the characters of the operation.
    public String getCharacters(){
        return characters;
    }

    //This function returns the result of the operation.
    public String getResult(){
        return result;
    }
}
