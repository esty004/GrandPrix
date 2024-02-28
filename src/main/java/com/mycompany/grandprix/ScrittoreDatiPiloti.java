/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Esty
 */
public class ScrittoreDatiPiloti implements Runnable {

    private String nomeFile;
    private Pilota[] piloti;

    public ScrittoreDatiPiloti(String nomeFile, Pilota[] piloti) {
        this.nomeFile = nomeFile;
        this.piloti = piloti;
    }

    @Override
    public void run() {
        scrivi();
    }

    public void scrivi() {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            for (Pilota pilota : piloti) {
                br.write("<" + pilota.nome + ">");
                br.write("\n\r");
                br.write("<" + pilota.modelloAuto + ">");
                br.write("\n\r");
            }
            br.flush();
        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
