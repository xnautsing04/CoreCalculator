package com.example.corecalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InputLineTest {
    private InputLine testLine;

    @Before
    public void setUp() throws Exception {
        testLine = new InputLine();
    }

    @After
    public void tearDown() throws Exception {
        testLine = null;
        assertNull(testLine);
    }

    @Test
    public void addRetrieveOperation() {
        Operation op = new Operation("2+2");
        testLine.addOperation(op);
        assertEquals("2+2", testLine.retrieveOperations().get(0).getCharacters());
    }
}