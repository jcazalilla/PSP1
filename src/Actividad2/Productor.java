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
        this.nombre = nombre;
    }

    @Override
    public void run() {

        //acción de nuestro propio semáforo
        smf.entraNumero(nombre, this.al);
        //Notificación de finalazación del hilo
        //fuera del contexto "synchronized" 
        finalizaProduccion();

    }

    private synchronized void finalizaProduccion() {
        notifyAll();
    }
}
