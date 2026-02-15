package com.example.solid.isp;

public class HumanWorker implements Workable, Eatable {
    private String currentTask;
    private double workHours;
    private String name;
    private String mealPreference;
    
    public HumanWorker(String name, String mealPreference) {
        this.name = name;
        this.mealPreference = mealPreference;
        this.workHours = 0;
    }
    
    @Override
    public void work() {
        currentTask = "Realizando tareas de oficina";
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
    
    @Override
    public void eat() {
        System.out.println(name + " está comiendo " + mealPreference);
    }
    
    @Override
    public void takeBreak() {
        System.out.println(name + " está en descanso de 15 minutos");
    }
    
    @Override
    public String getMealPreference() {
        return mealPreference;
    }
}