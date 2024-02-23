package com.mycompany.grandprix;

/**
 *
 * @author esty
 */
import java.util.Random;
import java.util.Scanner;

public class Pilota extends Thread {

    String nome;
    String modelloAuto;
    String nomeCircuito;
    int ngiri;
    int lunghezzaCircuito;
    int numeroPitStopPossibili;
    int scelta;

    public Pilota(String nome, String modelloAuto, String nomeCircuito, int ngiri, int lunghezzaCircuito, int numeroPitStopPossibili, int scelta) {
        this.nome = nome;
        this.modelloAuto = modelloAuto;
        this.nomeCircuito = nomeCircuito;
        this.ngiri = ngiri;
        this.lunghezzaCircuito = lunghezzaCircuito;
        this.numeroPitStopPossibili = numeroPitStopPossibili;
        this.scelta = scelta;
    }

    @Override
    public void run() {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int giriCompletati = 0;
        int posizione = 0;

        while (giriCompletati < ngiri) {
            int distanzaPercorsa = 0;
            switch (scelta) {
                case 1:
                    distanzaPercorsa = rand.nextInt(100); // Distanza casuale percorsa in metri
                    // Simulazione movimento dell'auto
                    posizione += distanzaPercorsa;

                    pitStop(posizione);

                    incidente(nome, rand);

                    safetyCar(rand);

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
                    break;
                case 2:
                    distanzaPercorsa = rand.nextInt(200); // Distanza casuale percorsa in metri
                    // Simulazione movimento dell'auto
                    posizione += distanzaPercorsa;

                    pitStop(posizione);

                    incidente(nome, rand);

                    safetyCar(rand);

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
                    break;
            }
        }

        System.out.println(nome + " ha completato la gara.");

    }

    public void pitStop(int posizione) {
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
    }

    public void incidente(String nome, Random rand) {
        // Verifica se si è verificato un incidente
        if (rand.nextDouble() < 0.05) { // Probabilità del 5% di incidente
            System.out.println("Incidente! " + nome + " è costretto ad abbandonare la gara.");
        }

    }

    public void safetyCar(Random rand) {
        // Verifica se è necessario far intervenire la safety car
        if (rand.nextDouble() < 0.02) { // Probabilità del 2% di intervento della safety car
            System.out.println("Safety car in pista!");
            try {
                Thread.sleep(3000); // Simulazione del tempo di intervento della safety car (3 secondi)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void salvaDatiPiloti() {
        ScrittoreDatiPiloti scrittore = new ScrittoreDatiPiloti("salvataggioPiloti.csv", nome, modelloAuto);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }
}
