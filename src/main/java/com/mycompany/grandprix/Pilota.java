/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

import java.util.Random;

/**
 *
 * @author Magdalena
 */
public class Pilota extends Thread {

    String nome;
    String modelloAuto;
    boolean running = true;
    float distanza;

    public Pilota(String nome, String modelloAuto) {
        this.nome = nome;
        this.modelloAuto = modelloAuto;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (running) {
            float distanceCovered = random.nextFloat() * 10;
            distanza += distanceCovered;
            System.out.println(nome + " ha percorso " + distanceCovered + " metri. Distanza totale: " + distanza + " metri");

            try {
                // Attendi 1 secondo prima del prossimo turno
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void stopThread() {
        this.running = false;
    }
}
