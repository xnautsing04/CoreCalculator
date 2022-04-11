package com.example.corecalculator;

import java.util.ArrayList;

public class InputLine {
    //This stores all the operations calculated by the user.
    private ArrayList<Operation> operations;

    //This constructor sets operations to an empty ArrayList.
    public InputLine(){
        operations = new ArrayList<Operation>();
    }

    //This returns a list of all operations.
    public ArrayList<Operation> retrieveOperations(){
        return operations;
    }

    //This adds an operation to the list of all operations.
    public void addOperation(Operation newOperation){
        operations.add(newOperation);
    }
}
