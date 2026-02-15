package com.example.solid.isp;

public class HumanWorker implements Workable, Eatable {

    @Override
    public void work() {
        System.out.println("Trabajando...");
    }

    @Override
    public void eat() {
        System.out.println("Almorzando...");
    }
}