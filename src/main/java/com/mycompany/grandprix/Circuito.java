/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

import java.util.Scanner;

/**
 *
 * @author esty
 */
public class Circuito {

    String nomeCircuito;
    int ngiri;
    int lunghezzaCircuito;
    int numeroPitStopPossibili;

    public Circuito(String nomeCircuito, int ngiri, int lunghezzaCircuito, int numeroPitStopPossibili) {
        this.nomeCircuito = nomeCircuito;
        this.ngiri = ngiri;
        this.lunghezzaCircuito = lunghezzaCircuito;
        this.numeroPitStopPossibili = numeroPitStopPossibili;
    }

    public void gestionePiloti() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci il numero di piloti che partecipano alla gara:");
        int npiloti = scan.nextInt();
        Pilota[] piloti = new Pilota[npiloti]; // Creazione di un array di piloti
        for (int i = 0; i < piloti.length; i++) {
            scan.nextLine();
            System.out.println("Inserisci nome del pilota:");
            String nomePilota = scan.nextLine();
            System.out.println("Inserisci modello dell'auto:");
            String modelloAuto = scan.nextLine();
            System.out.println("Che tipo di auto ha questo pilota?");
            System.out.println("1. Base");
            System.out.println("2. truccata");
            int scelta = scan.nextInt();
            piloti[i] = new Pilota(nomePilota, modelloAuto, nomeCircuito, ngiri, lunghezzaCircuito, numeroPitStopPossibili, scelta);
        }// Inserimento dati del pilota per il numero di piloti specificato dall'utente
        for (int i = 0; i < piloti.length; i++) {
            piloti[i].start();
            piloti[i].salvaDatiPiloti();
        }// Avvio di tutti i thread piloti
    }
}
