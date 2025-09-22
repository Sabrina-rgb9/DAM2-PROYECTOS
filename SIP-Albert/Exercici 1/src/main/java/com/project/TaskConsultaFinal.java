package main.java.com.project;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class TaskConsultaFinal implements Callable<Double> {
    private final ConcurrentHashMap<String, Double> compte;

    public TaskConsultaFinal(ConcurrentHashMap<String, Double> compte) {
        this.compte = compte;
    }

    @Override
    public Double call() {
        try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
        Double saldoFinal = compte.getOrDefault("saldo", 0.0);
        System.out.println("Consulta final: " + saldoFinal);
        return saldoFinal;
    }
}