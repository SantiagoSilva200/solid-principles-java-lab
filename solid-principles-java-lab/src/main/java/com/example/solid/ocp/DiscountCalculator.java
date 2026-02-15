package com.example.solid.ocp;

import java.util.HashMap;
import java.util.Map;

public class DiscountCalculator {
    private Map<String, DiscountStrategy> strategies = new HashMap<>();
    
    public DiscountCalculator() {
        registerStrategy(new RegularDiscount());
        registerStrategy(new VIPDiscount());
    }
    
    public void registerStrategy(DiscountStrategy strategy) {
        strategies.put(strategy.getCustomerType(), strategy);
    }
    
    public double calculateDiscount(String customerType, double price) {
        DiscountStrategy strategy = strategies.get(customerType);
        if (strategy == null) {
            return 0;
        }
        return strategy.calculateDiscount(price);
    }
    
    public double calculateFinalPrice(String customerType, double price) {
        double discount = calculateDiscount(customerType, price);
        return price - discount;
    }
}