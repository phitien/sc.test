package com.app.calculators;

import com.app.models.Product;

/**
 * Created by phitien on 8/12/16.
 */
public class Calculator implements ICalculator {
    @Override
    public Float calculate(Product product) {
        return product.getPrice();
    }
}
