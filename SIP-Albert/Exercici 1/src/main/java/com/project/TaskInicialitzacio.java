package com.project;

import java.util.concurrent.ConcurrentHashMap;

public class TaskInicialitzacio implements Runnable {
    private final ConcurrentHashMap<String, Double> compte;

    public TaskInicialitzacio(ConcurrentHashMap<String, Double> compte) {
        this.compte = compte;
    }

    @Override
    public void run() {
        compte.put("Dinero", 1000.0);
        System.out.println("Dinero en la cuenta inicial: " + compte.get("Dinero"));
    }
}