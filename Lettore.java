/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author esty
 */
public class Lettore extends Thread {

    String nomeFile;

    public Lettore(String nomeFile) {
        this.nomeFile = nomeFile;
    }

    /**
     * Legge il file senza tener conto del tipo di file e lo mostra in output
     */
    public void leggi() {
        FileReader fr;
        int i;
        try {
            //1) apro il file
            fr = new FileReader(nomeFile);
            //2) leggo carattere per carattere e lo stampo 
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }

            System.out.print("\n\r");
            //3) chiudo il file
            fr.close();
        } catch (IOException ex) {
            System.err.println("Errore in lettura!");
        }
    }

    public void run() {
        leggi();
    }
}
