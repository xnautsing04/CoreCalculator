package com.example.corecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.ArrayList;

public class Calculator extends AppCompatActivity {

    //This references the EditText object in the activity_main.xml file.
    private EditText display;

    //This is the InputLine object that will store the history of operations.
    InputLine lineHistory;

    //This array creates Button objects corresponding to all buttons found in the UI.
    Button[] buttons= {new Button("C"),
            new Button("()"),
            new Button("="),
            new Button("0"),
            new Button("1"),
            new Button("2"),
            new Button("3"),
            new Button("4"),
            new Button("5"),
            new Button("6"),
            new Button("7"),
            new Button("8"),
            new Button("9"),
            new Button("×"),
            new Button("÷"),
            new Button("+"),
            new Button("-"),
            new Button("^"),
            new Button("+/-"),
            new Button("."),
            new Button ("log"),
            new Button("e"),
            new Button("π"),
            new Button ("hist"),
            new Button("tan"),
            new Button ("cos"),
            new Button ("sin")
    };

    //This function runs on the creation of the application, which sets up the necessary initial assignments.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        lineHistory = new InputLine();

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (getString(R.string.input).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    //This function updates the text according to the text that is being passed as well as the current position of the cursor.
    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();

        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if(getString(R.string.input).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos+strToAdd.length());
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos+strToAdd.length());
        }
    }

    //The following functions all act as onClick functions, adding the necessary text to the display.
    public void zeroBTN(View view){
        updateText(buttons[3].buttonClicked(display));
    }

    public void oneBTN(View view){
        updateText(buttons[4].buttonClicked(display));
    }

    public void twoBTN(View view){
        updateText(buttons[5].buttonClicked(display));
    }

    public void threeBTN(View view){
        updateText(buttons[6].buttonClicked(display));
    }

    public void fourBTN(View view){
        updateText(buttons[7].buttonClicked(display));
    }

    public void fiveBTN(View view){
        updateText(buttons[8].buttonClicked(display));
    }

    public void sixBTN(View view){
        updateText(buttons[9].buttonClicked(display));
    }

    public void sevenBTN(View view){
        updateText(buttons[10].buttonClicked(display));
    }

    public void eightBTN(View view){
        updateText(buttons[11].buttonClicked(display));
    }

    public void nineBTN(View view){
        updateText(buttons[12].buttonClicked(display));
    }

    public void multiplyBTN(View view){
        updateText(buttons[13].buttonClicked(display));
    }

    public void divideBTN(View view){
        updateText(buttons[14].buttonClicked(display));
    }

    public void subtractBTN(View view){
        updateText(buttons[16].buttonClicked(display));
    }

    public void addBTN(View view){
        updateText(buttons[15].buttonClicked(display));
    }

    //This function clears the screen when the user clicks on the C button.
    public void clearBTN(View view){
        buttons[0].buttonClicked(display);
    }

    //This function uses the logic found in the buttonClicked function to update the text with the correct parenthesis.
    public void parBTN(View view){
        int cursorPos = display.getSelectionStart();
        updateText(buttons[1].buttonClicked(display));
        display.setSelection(cursorPos+1);
    }

    public void expBTN(View view){
        updateText(buttons[17].buttonClicked(display));
    }

    public void plusMinusBTN(View view){
        updateText(buttons[18].buttonClicked(display));
    }

    public void decimalBTN(View view){
        updateText(buttons[19].buttonClicked(display));
    }

    //This function adds the operation to the lineHistory after calculating it and placing the answer in the display.
    public void equalBTN(View view){
        String newOp = buttons[2].buttonClicked(display);
        Operation op = new Operation(newOp);

        lineHistory.addOperation(op);
    }

    public void logBTN(View view){
        updateText(buttons[20].buttonClicked(display));
    }

    public void eBTN(View view){
        updateText(buttons[21].buttonClicked(display));
    }

    public void piBTN(View view){
        updateText(buttons[22].buttonClicked(display));
    }

    //Use this to load the retrieve previous equations by changing the layout currently displayed.
    public void histBTN(@NonNull View view){
        ArrayList<Operation> operations = lineHistory.retrieveOperations();
        TableLayout buttonLayout = findViewById(R.id.tableLayout);
        ImageButton backSpace = findViewById(R.id.button21);

        display.setVisibility(View.GONE);
        buttonLayout.setVisibility(View.GONE);
        backSpace.setVisibility(View.GONE);

        ScrollView historyScroller = findViewById(R.id.scroller);
        historyScroller.setVisibility(View.VISIBLE);
        LinearLayout historyHolder = findViewById(R.id.historyHolder);

        historyHolder.removeAllViews();

        for(int i = operations.size()-1; i >= 0; --i){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);




            android.widget.Button newButton = new android.widget.Button(this);
            newButton.setLayoutParams(params);
            operations.get(i).calculateOperation();
            newButton.setText(operations.get(i).getCharacters() + " = " + operations.get(i).getResult());
            newButton.setId(i);

            newButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    String eq = newButton.getText().toString();
                    String op = eq.split("=")[0];
                    display.setVisibility(View.VISIBLE);
                    buttonLayout.setVisibility(View.VISIBLE);
                    backSpace.setVisibility(View.VISIBLE);

                    historyScroller.setVisibility(View.GONE);

                    display.setText("");
                    updateText(op);

                }
            });
            historyHolder.addView(newButton);
        }
        historyHolder.invalidate();

    }

    public void tanBTN(View view){
        updateText(buttons[24].buttonClicked(display));
    }

    public void cosBTN(View view){
        updateText(buttons[25].buttonClicked(display));
    }

    public void sinBTN(View view){
        updateText(buttons[26].buttonClicked(display));
    }

    //This is a special button, using an image, that removes text based on where the cursor is.
    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen!=0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
}