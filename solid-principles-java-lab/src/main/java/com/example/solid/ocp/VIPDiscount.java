package com.example.solid.ocp;
public class VIPDiscount implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.20;
    }
}
