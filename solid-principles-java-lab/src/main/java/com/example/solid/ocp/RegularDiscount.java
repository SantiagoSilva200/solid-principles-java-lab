package com.example.solid.ocp;

public class RegularDiscount implements DiscountStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.10;
    
    @Override
    public double calculateDiscount(double price) {
        return price * DISCOUNT_PERCENTAGE;
    }
    
    @Override
    public String getCustomerType() {
        return "Regular";
    }
}