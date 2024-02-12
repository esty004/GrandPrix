/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

import java.util.Scanner;

/**
 *
 * @author Magdalena
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

    public void salvaDatiCifrati() {
        Scrittore scrittore = new Scrittore("salvataggio.csv", username, passwordCifrata);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }

    public void avviaGara() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci nome circuito:");
        String circuito = scan.nextLine();
        System.out.println("Numero di giri della gara:");
        int ngiri = scan.nextInt();
        System.out.println("Inserisci la lunghezza del circuito(in metri):");
        int lunghezza = scan.nextInt();
        System.out.println("inserisci il numero di piloti che partecipano alla gara");
        int npiloti = scan.nextInt();
        Pilota[] piloti = Pilota[npiloti];
        for (int i = 0; i < piloti.length; i++) {
            System.out.println("Inserisci nome del pilota:");
            String nomePilota = scan.nextLine();
            System.out.println("Inserisci modello dell'auto:");
            String modelloAuto = scan.nextLine();
            piloti[i] = new Pilota(nomePilota, modelloAuto, circuito, ngiri, lunghezza);
        }

    }

}
