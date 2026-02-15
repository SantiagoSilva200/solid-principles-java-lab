package com.example.solid.lsp;

public class ElectricCar implements Drivable, Chargeable {
    private double speed;
    private double batteryLevel;
    private String model;
    
    public ElectricCar(String model) {
        this.model = model;
        this.speed = 0;
        this.batteryLevel = 100;
    }
    
    @Override
    public void drive() {
        speed = 120;
        batteryLevel -= 8;
        System.out.println(model + " conduciendo silenciosamente a " + speed + " km/h");
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
    public void charge() {
        batteryLevel = 100;
        System.out.println(model + " cargado completamente");
    }
    
    @Override
    public double getBatteryLevel() {
        return batteryLevel;
    }
}