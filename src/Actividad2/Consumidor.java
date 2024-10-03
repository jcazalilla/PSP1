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

    String nombre;
    //TablaNumeros tb = new TablaNumeros();
    SemaforoTabla smf = new SemaforoTabla();

    public Consumidor(String nombre0) {

        this.nombre = nombre;
    }

    @Override
    public void run() {

        try {
            smf.saleNumero(nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
}
