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
public class Productor extends Thread {

    String nombre; //nombre del hilo
    //TablaNumeros tb = new TablaNumeros();
    Semaforo smf = new Semaforo();

    public Productor(String nombre) {

        this.nombre = nombre;
    }

    @Override
    public void run() {

        try {
            smf.entraNumero(nombre);
            
            //notifyAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        smf.finaliza();
    }
}
