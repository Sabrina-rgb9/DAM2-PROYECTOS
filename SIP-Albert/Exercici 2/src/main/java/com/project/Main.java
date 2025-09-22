package com.project;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        CompletableFuture<Void> cadena = CompletableFuture // 
            .supplyAsync(() -> {
                System.out.println("Validant dades de la sol·licitud...");
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                String dadesValidades = "Dades valides: user1";
                System.out.println("Validacio completada.");
                return dadesValidades;
            })
            .thenApply(dades -> {
                System.out.println("Processant dades...");
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
                String resultat = dades + " | Resultat: Positius";
                System.out.println("Processament completat.");
                return resultat;
            })
            .thenAccept(resultatFinal -> {
                System.out.println("Resposta enviada a l'usuari:");
                System.out.println(resultatFinal);
            });

        cadena.join();
    }
}