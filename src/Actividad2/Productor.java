/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad2;

import java.util.ArrayList;

/**
 *
 * @author Jesús Cazalilla
 */
public class Productor extends Thread {

    ArrayList<Integer> al;
    String nombre; // nombre del hilo
    Semaforo smf = new Semaforo();

    public Productor(String nombre, ArrayList<Integer> al) {

        this.al = al;
        this.nombre=nombre;
    }

    @Override
    public synchronized void run() {

        try {
            smf.entraNumero(nombre,this.al);
           
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }

        
        finalizaProduccion();

    }

    private synchronized void finalizaProduccion() {

        notifyAll();

    }

}
