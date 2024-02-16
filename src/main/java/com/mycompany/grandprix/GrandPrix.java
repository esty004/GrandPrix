/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.grandprix;

/**
 *
 * @author esty
 */
public class GrandPrix {

    public static void main(String[] args) {
        Giocatore giocatore1 = new Giocatore("esty", "nope", "verme");//sto creando un istanza della classe giocatore
        giocatore1.criptaVigenere();//serve per criptare la password usando la chiave
        giocatore1.salvaDatiCifrati();//serve a salvare i dati cifrati su un file
        giocatore1.avviaGara();
        
    }
}
