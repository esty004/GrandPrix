package com.mycompany.grandprix;

import java.util.Random;

/**
 *
 * @author esty
 */
import java.util.Random;

public class Pilota extends Thread {
    String nome;
    String modelloAuto;
    String nomeCircuito;
    int ngiri;
    int lunghezzaCircuito;
    int numeroPitStopPossibili;

    public Pilota(String nome, String modelloAuto, String nomeCircuito, int ngiri, int lunghezzaCircuito, int numeroPitStopPossibili) {
        this.nome = nome;
        this.modelloAuto = modelloAuto;
        this.nomeCircuito = nomeCircuito;
        this.ngiri = ngiri;
        this.lunghezzaCircuito = lunghezzaCircuito;
        this.numeroPitStopPossibili = numeroPitStopPossibili;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int giriCompletati = 0;
        int posizione = 0;
        
        while (giriCompletati < ngiri) {
            // Simulazione movimento dell'auto
            int distanzaPercorsa = rand.nextInt(100); // Distanza casuale percorsa in metri
            posizione += distanzaPercorsa;
            
            // Verifica se è necessario un pit stop
            if (posizione % (lunghezzaCircuito / numeroPitStopPossibili) == 0) {
                // Esegue il pit stop
                System.out.println(nome + " sta effettuando un pit stop.");
                try {
                    Thread.sleep(2000); // Simulazione del tempo di un pit stop (2 secondi)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            // Verifica se si è verificato un incidente
            if (rand.nextDouble() < 0.05) { // Probabilità del 5% di incidente
                System.out.println("Incidente! " + nome + " è costretto ad abbandonare la gara.");
                break;
            }
            
            // Verifica se è necessario far intervenire la safety car
            if (rand.nextDouble() < 0.02) { // Probabilità del 2% di intervento della safety car
                System.out.println("Safety car in pista!");
                try {
                    Thread.sleep(3000); // Simulazione del tempo di intervento della safety car (3 secondi)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            // Verifica se è stato completato un giro
            if (posizione >= lunghezzaCircuito) {
                System.out.println(nome + " ha completato il giro " + (giriCompletati + 1) + " su " + ngiri);
                posizione -= lunghezzaCircuito; // Resetta la posizione per il nuovo giro
                giriCompletati++;
            }
            
            // Simulazione di avanzamento del tempo (1 secondo)
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(nome + " ha completato la gara.");
    }
}
