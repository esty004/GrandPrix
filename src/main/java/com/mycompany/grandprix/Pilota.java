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

    public Pilota(String nome, String modelloAuto){
        this.nome = nome;
        this.modelloAuto = modelloAuto;
    }
    @Override
    public void run(){
        
    }
}
