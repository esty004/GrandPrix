/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.grandprix;

/**
 *
 * @author Studenti
 */
public class GrandPrix {

    public static void main(String[] args) {
        Giocatore giocatore1 = new Giocatore("esty", "nope", "verme");
        giocatore1.criptaVigenere();
        giocatore1.salvaDatiCifrati();
        giocatore1.avviaGara();
    }
}
