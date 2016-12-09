package com.app.calculators;

import com.app.exceptions.CalculatorNull;
import com.app.models.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by phitien on 8/12/16.
 */
public class TestCalculator {
    Product product;
    Product child1;
    Product child2;
    Product child3;

    @Before
    public void setUp() {
        product = new Product();
        product.setPrice(Float.valueOf(1000));

        child1 = new Product();
        child1.setPrice(Float.valueOf(1000));

        child2 = new Product();
        child2.setPrice(Float.valueOf(1000));

        child3 = new Product();
        child3.setPrice(Float.valueOf(1000));

        product.getChildren().add(child1);
        product.getChildren().add(child2);
        product.getChildren().add(child3);
    }

    @Test
    public void testNormalCalculator() throws CalculatorNull {

        child1.setCalculatorClass(NormalCalculator.class);//return 1000 as calculate as normal
        assertEquals(Float.valueOf(1000), child1.calculatePrice());

        child2.setCalculatorClass(NormalCalculator.class);//return 1000 as calculate as normal
        assertEquals(Float.valueOf(1000), child2.calculatePrice());

        child3.setCalculatorClass(NormalCalculator.class);//return 1000 as calculate as normal
        assertEquals(Float.valueOf(1000), child3.calculatePrice());

        product.setCalculatorClass(NormalCalculator.class);
        assertEquals(Float.valueOf(3000), product.calculatePrice());

    }

    @Test
    public void testPromotionCalculator() throws CalculatorNull {

        child1.setCalculatorClass(PromotionCalculator.class);//return 0 as calculate as promotion and free
        child1.setFree(true);
        assertEquals(Float.valueOf(0), child1.calculatePrice());

        child2.setCalculatorClass(PromotionCalculator.class);//return 1000 as calculate as normal
        assertEquals(Float.valueOf(1000), child2.calculatePrice());

        child3.setCalculatorClass(PromotionCalculator.class);//return 1000 as calculate as normal
        assertEquals(Float.valueOf(1000), child3.calculatePrice());

        product.setCalculatorClass(PromotionCalculator.class);
        assertEquals(Float.valueOf(2000), product.calculatePrice());

    }

    @Test
    public void testCalculators() throws CalculatorNull {

        child1.setCalculatorClass(NormalCalculator.class);//return 1000 as calculate as normal
        child1.setFree(true);
        assertEquals(Float.valueOf(1000), child1.calculatePrice());

        child2.setCalculatorClass(PromotionCalculator.class);//return 0 as calculate as promotion and free
        child2.setFree(true);
        assertEquals(Float.valueOf(0), child2.calculatePrice());

        child3.setCalculatorClass(PromotionCalculator.class);//return 1000 as calculate as promotion but not free
        assertEquals(Float.valueOf(1000), child3.calculatePrice());

        product.setCalculatorClass(PromotionCalculator.class);
        assertEquals(Float.valueOf(2000), product.calculatePrice());

    }

}
