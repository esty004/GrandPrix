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
public class Circuito {

    String nomeCircuito;
    int ngiri;
    int lunghezzaCircuito;

    public Circuito(String nomeCircuito, int ngiri, int lunghezzaCircuito) {
        this.nomeCircuito = nomeCircuito;
        this.ngiri = ngiri;
        this.lunghezzaCircuito = lunghezzaCircuito;
    }

    public void gestionePiloti() {
        Scanner scan = new Scanner(System.in);
        System.out.println("inserisci il numero di piloti che partecipano alla gara");
        int npiloti = scan.nextInt();
        Pilota[] piloti = new Pilota[npiloti];
        for (int i = 0; i < piloti.length; i++) {
            scan.nextLine();
            System.out.println("Inserisci nome del pilota:");
            String nomePilota = scan.nextLine();
            System.out.println("Inserisci modello dell'auto:");
            String modelloAuto = scan.nextLine();
            piloti[i] = new Pilota(nomePilota, modelloAuto);
        }
        for(int i = 0; i < piloti.length; i++){
            piloti[i].start();
        }
        
    }
    
}
