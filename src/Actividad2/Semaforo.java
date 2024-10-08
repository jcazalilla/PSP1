/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad2;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jesús Cazalilla
 */
public class Semaforo {

    ArrayList<Integer> al;
    int suma = 0, indice = 0, numero = 0;

    public Semaforo() {
        this.al = new ArrayList<>();

    }

    public synchronized void entraNumero(String nombre) {

        while (suma < 100) {

            if (al.size() < 10) {
                try {
                    numero = (int) (Math.random() * 11);//aleatorio de 0..10
                    al.add(numero);
                    indice = al.size() - 1;
                    suma += numero;
                    System.out.printf("Hilo %s, introduce el valor %d en la posición %d, Array = %s, Suma=%d \n",
                            nombre, numero, indice, al, suma);

                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (al.size() >= 10) {
                try {
                    wait();

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

            }

        }
        notify();

    }

    public synchronized void saleNumero(String nombre) {

        if (al.size() > 0) {
            try {
                //si no está vacio puede sacar números
                indice = al.size() - 1;
                numero = al.get(indice);
                al.remove(indice);
                suma -= numero;
                System.out.printf("Hilo %s, saca el valor %d en la posición %d, Array = %s, Suma=%d \n",
                        nombre, numero, indice, al, suma);
                sleep(1500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (al.isEmpty()) {
            try {
                wait();

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
        notify();
    }

}
