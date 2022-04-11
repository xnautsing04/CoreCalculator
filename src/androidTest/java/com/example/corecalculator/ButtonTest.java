package com.example.corecalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import android.content.Context;
import android.widget.EditText;

import androidx.test.core.app.ApplicationProvider;

public class ButtonTest {

    Button cButton;
    Button parButton;
    Button eqButton;
    Button plusMinusButton;
    Button sinButton;
    Button cosButton;
    Button tanButton;
    Button logButton;
    Button elseButton;
    EditText newEdit;

    @Before
    public void setUp() throws Exception {
        cButton = new Button ("C");
        parButton = new Button ("()");
        eqButton = new Button ("=");
        plusMinusButton = new Button ("+/-");
        sinButton = new Button ("sin");
        cosButton = new Button ("cos");
        tanButton = new Button ("tan");
        logButton = new Button ("log");
        elseButton = new Button ("0");
        newEdit = new EditText(ApplicationProvider.getApplicationContext());
    }

    @After
    public void tearDown() throws Exception {
        cButton = null;
        parButton = null;
        eqButton = null;
        plusMinusButton = null;
        sinButton = null;
        cosButton = null;
        tanButton = null;
        logButton = null;
        elseButton = null;

        assertNull(cButton);
        assertNull(parButton);
        assertNull(eqButton);
        assertNull(plusMinusButton);
        assertNull(sinButton);
        assertNull(cosButton);
        assertNull(tanButton);
        assertNull(logButton);
        assertNull(elseButton);
    }

    @Test
    public void cButtonClicked() {
        assertEquals("", cButton.buttonClicked(newEdit));
    }

    @Test
    public void parButtonClicked() {
        assertEquals("(", parButton.buttonClicked(newEdit));
    }

    @Test
    public void eqButtonClicked() {
        assertEquals("", eqButton.buttonClicked(newEdit));
    }

    @Test
    public void plusMinusButtonClicked() {
        assertEquals("-", plusMinusButton.buttonClicked(newEdit));
    }

    @Test
    public void sinButtonClicked() {
        assertEquals("sin(", sinButton.buttonClicked(newEdit));
    }

    @Test
    public void cosButtonClicked() {
        assertEquals("cos(", cosButton.buttonClicked(newEdit));
    }

    @Test
    public void tanButtonClicked() {
        assertEquals("tan(", tanButton.buttonClicked(newEdit));
    }

    @Test
    public void logButtonClicked() {
        assertEquals("log(,)", logButton.buttonClicked(newEdit));
    }

    @Test
    public void elseButtonClicked() {
        assertEquals("0", elseButton.buttonClicked(newEdit));
    }
}