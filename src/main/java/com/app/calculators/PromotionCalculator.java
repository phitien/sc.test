package com.app.calculators;

import com.app.models.Product;

/**
 * Created by phitien on 8/12/16.
 */
public class PromotionCalculator extends Calculator {
    @Override
    public Float calculate(Product product) {
        return product.getFree() ? 0 : product.getPrice();
    }
}
