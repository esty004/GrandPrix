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

    String nomeFile;
    String nome;
    String modelloAuto;

    public ScrittoreDatiPiloti(String nomeFile, String nome, String modelloAuto) {
        this.nomeFile = nomeFile;
        this.nome = nome;
        this.modelloAuto = modelloAuto;
    }

    @Override
    public void run() {
        scrivi();
    }

    /**
     * Scrive un file di testo usando la classe BufferedWriter
     */
    public void scrivi() {

        try (BufferedWriter br = new BufferedWriter(new FileWriter(nomeFile))) {
            br.write("<" + nome + ">");
            br.write("\n\r");
            br.write("<" + modelloAuto + ">");
            br.write("\n\r");
            br.flush();

        } catch (IOException ex) {
            Logger.getLogger(Scrittore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
