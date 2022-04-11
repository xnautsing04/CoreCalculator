package com.example.corecalculator;

import android.widget.EditText;


public class Button {
    //This stores the operand that is used to represent the operation corresponding to that button.
    String operand;

    //Constructor that stores op as operand.
    public Button (String op){
        operand = op;
    }

    //This function initiates the correct operations or actions based on the operand.
    public String buttonClicked(EditText display) {
        //Display an empty string if operand is "C".
        if (operand == "C") {
            display.setText("");
            return "";
        }
        //Display either a "(" or ")" based on the logic of the operation at this point.
        else if (operand == "()") {
            int cursorPos = display.getSelectionStart();
            int openPar = 0;
            int closedPar = 0;
            int textLen = display.getText().length();

            for (int i = 0; i < cursorPos; ++i) {
                if (display.getText().toString().substring(i, i + 1).equals("(")) {
                    openPar += 1;
                }
                if (display.getText().toString().substring(i, i + 1).equals(")")) {
                    closedPar += 1;
                }
            }

            if (openPar == closedPar || display.getText().toString().substring(textLen - 1, textLen).equals("(")) {
                return "(";
            } else if (closedPar < openPar && !display.getText().toString().substring(textLen - 1, textLen).equals("(")) {
                return ")";
            }
        }
        //Call the operation class and calculate the parsed operation based on what is currently in the display.
        else if (operand == "="){
            String userExp = display.getText().toString();
            userExp = userExp.replaceAll("÷", "/");
            userExp = userExp.replaceAll("×", "*");
            userExp = userExp.replaceAll("π", "pi");

            Operation op = new Operation(userExp);
            op.calculateOperation();
            String opResult = op.getResult();
            display.setText(opResult);
            display.setSelection(opResult.length());

            return userExp;
        }
        //Return a negative sign if the user clicks the +/- button.
        else if (operand == "+/-"){
            return "-";
        }
        //Return a sin function with an open parenthesis.
        else if (operand == "sin"){
            return "sin(";
        }
        //Returns a cos function with an open parenthesis.
        else if (operand == "cos"){
            return "cos(";
        }
        //Returns a tan function with a open parenthesis.
        else if (operand == "tan"){
            return "tan(";
        }
        //Returns a log function with a corresponding ,.
        else if (operand == "log"){
            return "log(,)";
        }
        //If none of these fit, then simply return the operand.
        return operand;
    }
}
