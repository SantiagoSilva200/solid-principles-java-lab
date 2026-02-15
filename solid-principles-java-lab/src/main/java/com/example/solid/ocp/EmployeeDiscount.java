package com.example.solid.ocp;

public class EmployeeDiscount implements DiscountStrategy {
    private static final double DISCOUNT_PERCENTAGE = 0.30;
    
    @Override
    public double calculateDiscount(double price) {
        return price * DISCOUNT_PERCENTAGE;
    }
    
    @Override
    public String getCustomerType() {
        return "Employee";
    }
}