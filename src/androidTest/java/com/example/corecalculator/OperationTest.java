package com.example.corecalculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OperationTest {

    private Operation testOp;

    @Before
    public void setUp() throws Exception {
        testOp = new Operation ("2+2");
    }

    @After
    public void tearDown() throws Exception {
        testOp = null;
        assertNull(testOp);
    }

    @Test
    public void calculateOperation() {
        testOp.calculateOperation();
        assertEquals(true, testOp.getResult() != null);
    }

    @Test
    public void getCharacters() {
        assertEquals("2+2", testOp.getCharacters());
    }

    @Test
    public void getResult() {
        testOp.calculateOperation();
        assertEquals("4.0", testOp.getResult());
    }
}