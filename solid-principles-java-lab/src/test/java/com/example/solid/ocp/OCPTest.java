package com.example.solid.ocp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountCalculatorTest {

    @Test
    void shouldApplyRegularDiscount() {
        DiscountCalculator calculator =
                new DiscountCalculator(new RegularDiscount());

        double discount = calculator.calculateDiscount(100);

        assertEquals(10, discount);
    }

    @Test
    void shouldApplyVipDiscount() {
        DiscountCalculator calculator =
                new DiscountCalculator(new VipDiscount());

        double discount = calculator.calculateDiscount(100);

        assertEquals(20, discount);
    }
}
