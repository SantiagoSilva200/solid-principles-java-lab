package com.example.solid.isp;

public class Developer implements Workable {
    private String currentTask;
    private double workHours;
    private String name;
    
    public Developer(String name) {
        this.name = name;
        this.workHours = 0;
    }
    
    @Override
    public void work() {
        currentTask = "Escribiendo código en Java";
        workHours += 8;
        System.out.println(name + " está " + currentTask);
    }
    
    @Override
    public String getCurrentTask() {
        return currentTask;
    }
    
    @Override
    public double getWorkHours() {
        return workHours;
    }
    
    public String getName() {
        return name;
    }
}