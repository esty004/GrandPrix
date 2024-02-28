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
    boolean running = true;
    boolean completatoSenzaIncidenti = true;
    long tempoTotale;

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
        Random rand = new Random();
        int giriCompletati = 0;
        int posizione = 0;
        Cronometro cronometro = new Cronometro();
        cronometro.avvia();

        while (giriCompletati < ngiri && running) {
            int distanzaPercorsa = 0;
            switch (scelta) {
                case 1:
                    distanzaPercorsa = rand.nextInt(100); // Distanza casuale percorsa in metri
                    // Simulazione movimento dell'auto
                    posizione += distanzaPercorsa;

                    pitStop(posizione);

                    incidente(rand);

                    giriCompletati = verificaGiro(posizione, lunghezzaCircuito, giriCompletati);
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

                    incidente(rand);

                    giriCompletati = verificaGiro(posizione, lunghezzaCircuito, giriCompletati);

                    // Simulazione di avanzamento del tempo (1 secondo)
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
        cronometro.ferma();
        tempoTotale = cronometro.getTempoTotale();
        System.out.println(nome + " ha completato la gara in: " + tempoTotale);
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

    public void incidente(Random rand) {
        // Verifica se si è verificato un incidente
        if (rand.nextDouble() < 0.05) { // Probabilità del 5% di incidente
            System.out.println("Incidente! " + nome + " è costretto ad abbandonare la gara.");
            completatoSenzaIncidenti = false;
            if (rand.nextDouble() < 0.02) { // Probabilità del 2% di intervento della safety car
                System.out.println("Safety car in pista, " + nome + " torna in gara");
                running = true;
                try {
                    Thread.sleep(3000); // Simulazione del tempo di intervento della safety car (3 secondi)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                running = false;
            }
            
        }
    }

    

    public int verificaGiro(int posizione, int lunghezzaCircuito, int giriCompletati) {
        // Verifica se è stato completato un giro
        if (posizione >= lunghezzaCircuito) {
            System.out.println(nome + " ha completato il giro " + (giriCompletati + 1) + " su " + ngiri);
            posizione -= lunghezzaCircuito; // Resetta la posizione per il nuovo giro
            giriCompletati++;
        }
        return giriCompletati;
    }

    public void salvaDatiPiloti(Pilota[] piloti) {
        ScrittoreDatiPiloti scrittore = new ScrittoreDatiPiloti("salvataggioPiloti.csv", piloti);
        Thread threadScrittore = new Thread(scrittore);
        threadScrittore.start();
    }

    public long getTempoTotale() {
        return tempoTotale;
    }
}
