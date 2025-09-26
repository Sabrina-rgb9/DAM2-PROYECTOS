package com.project;

import java.util.concurrent.*;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        // Estructura concurrent per compartir dades
        ConcurrentHashMap<String, Double> compte = new ConcurrentHashMap<>();

        // Una tasca (Runnable) que introdueixi les dades inicials, simulant la recepció d'una operació bancària.
        Runnable inicialitzador = () -> {
            System.out.println("Recepció operació bancària: saldo inicial 1000€");
                
            compte.put("saldo", 1000.0);
        };

        // Una altra tasca (Runnable) que modifiqui aquestes dades, simulant una operació de càlcul d'interessos o comissions.
        Runnable modificador = () -> {
            compte.put("saldo", compte.get("saldo") + 365); // Suma 365€ al saldo
            System.out.println("Saldo modificat: " + compte.get("saldo") + "€");
        };

        // Una tercera tasca (Callable) que llegeixi les dades modificades i retorni un resultat final, com ara el saldo actualitzat.
        Callable<Double> lector = () -> {
            try { Thread.sleep(800); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            Double saldoFinal = compte.get("saldo");
            return saldoFinal;
        };

        // Executor amb pool de 3 fils
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Executa les tasques
        executor.submit(inicialitzador);
        executor.submit(modificador);
        Future<Double> resultat = executor.submit(lector);

        // Mostra el resultat final
        System.out.println("Resultat final presentat al client: " + resultat.get() + "€");

        // Tanca l'executor
        executor.shutdown();
    }
}