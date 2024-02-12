/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grandprix;

/**
 *
 * @author Magdalena
 */
public class Pilota extends Thread{
    String nome;
    String modelloAuto;
    String nomeCircuito;
    int ngiri;
    int lunghezzaCircuito;
    
    public Pilota(String nome, String modelloAuto, String nomeCircuito, int ngiri, int lunghezzaCircuito){
        this.nome = nome;
        this.modelloAuto = modelloAuto;
        this.nomeCircuito = nomeCircuito;
        this.ngiri = ngiri;
        this.lunghezzaCircuito = lunghezzaCircuito;
    }
    @Override
    public void run(){
        
    }
}
