/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
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
        inizioGara();
        for (int i = 0; i < piloti.length; i++) {
            piloti[i].salvaDatiPiloti(piloti);
            piloti[i].start();
        }// Avvio di tutti i thread piloti

        // Attesa che tutti i piloti terminino la gara
        for (Pilota pilota : piloti) {
            try {
                pilota.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        fineGara(piloti);
    }

    // Metodo per notificare l'inizio della gara
    public void inizioGara() {
        System.out.println("La gara al circuito " + nomeCircuito + " è iniziata!");
    }

    public void fineGara(Pilota[] piloti) {
        System.out.println("La gara al circuito " + nomeCircuito + " è terminata!");

        // Ordinamento dei piloti in base al tempo totale
        Arrays.sort(piloti, Comparator.comparingLong(Pilota::getTempoTotale));

        // Gestione della posizione in classifica per i piloti con incidenti
        int posizione = 1;
        for (Pilota pilota : piloti) {
            if (!pilota.completatoSenzaIncidenti) {
                // Il pilota ha subito un incidente, impostiamo manualmente la sua posizione in classifica
                System.out.println(pilota.nome + " ha subito un incidente.");
                continue;
            }
            // Altrimenti, stampa la posizione in classifica normale
            System.out.println(posizione + ". " + pilota.nome + " - Tempo: " + pilota.getTempoTotale());
            posizione++;
        }

        // Comunicazione del vincitore
        System.out.println("Il vincitore della gara è: " + piloti[0].nome);

        // Salvataggio della classifica in un file
        try {
            FileWriter writer = new FileWriter("classifica.txt");
            for (int i = 0; i < piloti.length; i++) {
                writer.write((i + 1) + ". " + piloti[i].nome + " - Tempo: " + piloti[i].getTempoTotale() + "\n");
            }
            writer.close();
            System.out.println("La classifica è stata salvata nel file classifica.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Lettore lettore = new Lettore("classifica.txt");
        lettore.start();
    }
}
