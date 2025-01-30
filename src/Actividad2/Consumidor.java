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
public class Consumidor extends Thread {

    ArrayList<Integer> al;
    String nombre; //nombre del hilo
    Semaforo smf = new Semaforo();

    public Consumidor(String nombre, ArrayList<Integer> al) {

        this.nombre = nombre;
        this.al = al;
    }

    @Override
    public void run() {

        //acción de nuestro propio semáforo
        smf.saleNumero(this.nombre, this.al);
        //Notificación de finalazación del hilo
        //fuera del contexto "synchronized" 
        finalizaConsumidor();

    }

    private synchronized void finalizaConsumidor() {
        notifyAll();
    }
}
