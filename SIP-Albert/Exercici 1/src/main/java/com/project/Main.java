package com.project;

import com.project.TaskInicialitzacio;
import com.project.TaskModificacio;
import main.java.com.project.TaskConsultaFinal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ConcurrentHashMap<String, Double> compte = new ConcurrentHashMap<>();

        executor.execute(new TaskInicialitzacio(compte));
        executor.execute(new TaskModificacio(compte));
        Future<Double> resultat = executor.submit(new TaskConsultaFinal(compte));

        System.out.println("Resultat final per al client: " + resultat.get());
        executor.shutdown();
    }
}