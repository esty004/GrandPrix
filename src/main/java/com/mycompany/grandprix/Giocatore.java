/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

import java.util.Scanner;//libreria per abilitare lo scanner(serve per far mettere l'input all'utente)

/**
 *
 * @author esty
 */
public class Giocatore {

    String username;
    String password;
    String chiave;
    String passwordCifrata;

    public Giocatore(String username, String password, String chiave) {
        this.username = username;
        this.password = password;
        this.chiave = chiave;
    }
    
    //cripta la password utilizzando la chiave
    public String criptaVigenere() {
        StringBuilder passwordCifrata = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char carattere = password.charAt(i);
            char chiaveCorrispondente = chiave.charAt(i % chiave.length());

            // Esegue la cifratura di Vigenère
            char carattereCifrato = (char) ((carattere + chiaveCorrispondente) % 128);

            passwordCifrata.append(carattereCifrato);
        }

        this.passwordCifrata = passwordCifrata.toString();
        return this.passwordCifrata;
    }
    
    //salva l'username e la password cifrata su un file(salvataggio.csv)
    public void salvaDatiCifrati() {
        Scrittore scrittore = new Scrittore("salvataggio.csv", username, passwordCifrata);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }

    public void avviaGara() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci nome circuito:");
        String nomeCircuito = scan.nextLine();
        System.out.println("Numero di giri della gara:");
        int ngiri = scan.nextInt();
        System.out.println("Inserisci la lunghezza del circuito (in metri):");
        int lunghezza = scan.nextInt();
        System.out.println("Inserisci il numero di pit stop possibili:");
        int numeroPitStopPossibili = scan.nextInt();
        
        Circuito circuito = new Circuito(nomeCircuito, ngiri, lunghezza, numeroPitStopPossibili);
        circuito.gestionePiloti();
    }
}