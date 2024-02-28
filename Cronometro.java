/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Esty
 */
public class Cronometro {

    Timer timer;
    long millisecondi;

    public Cronometro() {
        this.timer = new Timer();
        this.millisecondi = 0;
    }

    public void avvia() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                millisecondi += 100; // Incremento di 100 millisecondi
            }
        }, 100, 100); // ritarda l'esecuzione di 100 millisecondi e quindi esegue ogni 100 millisecondi
    }
    
    public long getTempoTotale() {
        return millisecondi;
    }
    
    public void ferma() {
        timer.cancel(); // Annulla il Timer
    }
}
