package com.example.solid.lsp;

public class GasCar implements Drivable, Refuelable {
    private double speed;
    private double fuelLevel;
    private String model;
    
    public GasCar(String model) {
        this.model = model;
        this.speed = 0;
        this.fuelLevel = 100;
    }
    
    @Override
    public void drive() {
        speed = 100;
        fuelLevel -= 5;
        System.out.println(model + " conduciendo a " + speed + " km/h");
    }
    
    @Override
    public void stop() {
        speed = 0;
        System.out.println(model + " detenido");
    }
    
    @Override
    public double getSpeed() {
        return speed;
    }
    
    @Override
    public void refuel() {
        fuelLevel = 100;
        System.out.println(model + " repostado completamente");
    }
    
    @Override
    public double getFuelLevel() {
        return fuelLevel;
    }
}