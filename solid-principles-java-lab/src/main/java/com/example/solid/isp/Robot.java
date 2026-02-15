package com.example.solid.isp;

public class Robot implements Workable {
    private String currentTask;
    private double workHours;
    private String model;
    
    public Robot(String model) {
        this.model = model;
        this.workHours = 0;
    }
    
    @Override
    public void work() {
        currentTask = "Ejecutando tareas automatizadas";
        workHours += 24;
        System.out.println("Robot " + model + " " + currentTask);
    }
    
    @Override
    public String getCurrentTask() {
        return currentTask;
    }
    
    @Override
    public double getWorkHours() {
        return workHours;
    }
    
}