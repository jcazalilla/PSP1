/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesús Cazalilla
 */
public class Consumidor extends Thread {

    String nombre; //nombre del hilo
    Semaforo smf = new Semaforo();

    public Consumidor(String nombre) {

        this.nombre = nombre;
    }

    @Override
    public void run() {

        smf.saleNumero(nombre);
        
        //smf.finaliza();
    }
}
