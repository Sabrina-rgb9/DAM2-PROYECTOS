package com.project;

import java.util.concurrent.ConcurrentHashMap;

public class TaskModificacio implements Runnable {
    private final ConcurrentHashMap<String, Double> compte;

    public TaskModificacio(ConcurrentHashMap<String, Double> compte) {
        this.compte = compte;
    }

    @Override
    public void run() {
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        compte.computeIfPresent("saldo", (k, v) -> v + v * 0.05 - 10);
        System.out.println("Saldo modificat: " + compte.get("saldo"));
    }
}