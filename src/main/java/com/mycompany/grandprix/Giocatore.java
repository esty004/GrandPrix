/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

/**
 *
 * @author Magdalena
 */
public class Giocatore {

    String username;
    String password;
    String chiave;

    public Giocatore(String username, String password, String chiave) {
        this.username = username;
        this.password = password;
        this.chiave = chiave;
    }

    private static String criptaVigenere(String password, String chiave) {
        StringBuilder passwordCifrata = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char carattere = password.charAt(i);
            char chiaveCorrispondente = chiave.charAt(i % chiave.length());

            // Esegue la cifratura di Vigenère
            char carattereCifrato = (char) ((carattere + chiaveCorrispondente) % 128);

            passwordCifrata.append(carattereCifrato);
        }

        return passwordCifrata.toString();
    }

    public static void salvaDati(String username, String passwordCifrata) {
        Scrittore scrittore = new Scrittore("salvataggio.csv", username, passwordCifrata);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }

}
