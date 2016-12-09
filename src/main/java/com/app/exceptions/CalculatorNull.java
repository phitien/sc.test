package com.app.exceptions;

/**
 * Created by phitien on 8/12/16.
 */
public class CalculatorNull extends Exception {
    @Override
    public String getMessage() {
        return "NO_CALCULATOR_ASSIGNED";
    }
}
