package com.example.solid.ocp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OCPTest {
    
    private DiscountCalculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new DiscountCalculator();
    }
    
    @Test
    void testRegularDiscount() {
        double discount = calculator.calculateDiscount("Regular", 1000.0);
        assertEquals(100.0, discount);
        assertEquals(900.0, calculator.calculateFinalPrice("Regular", 1000.0));
    }
    
    @Test
    void testVIPDiscount() {
        double discount = calculator.calculateDiscount("VIP", 1000.0);
        assertEquals(200.0, discount);
        assertEquals(800.0, calculator.calculateFinalPrice("VIP", 1000.0));
    }
    
    @Test
    void testNewEmployeeDiscount() {
        calculator.registerStrategy(new EmployeeDiscount());
        double discount = calculator.calculateDiscount("Employee", 1000.0);
        assertEquals(300.0, discount);
    }
    
    @Test
    void testUnknownCustomerType() {
        double discount = calculator.calculateDiscount("Unknown", 1000.0);
        assertEquals(0, discount);
    }
}