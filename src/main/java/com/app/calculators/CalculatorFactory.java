package com.app.calculators;

/**
 * Created by phitien on 8/12/16.
 */
public interface CalculatorFactory<T extends ICalculator> {
    T getInstance();
}
