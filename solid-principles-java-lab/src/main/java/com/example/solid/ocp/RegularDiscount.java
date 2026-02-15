package com.example.solid.ocp;
public class RegularDiscount implements DiscountStrategy {

    @Override
    public double calculate(double price) {
        return price * 0.10;
    }
}
