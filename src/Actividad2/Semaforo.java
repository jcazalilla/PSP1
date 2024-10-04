/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad2;

import static java.lang.Thread.sleep;
import java.util.ArrayList;

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

    public synchronized void entraNumero(String nombre) throws InterruptedException {

        while (suma < 100) {
            if (al.size() < 10) {
                numero = (int) (Math.random() * 11);//aleatorio de 0..10
                al.add(numero);
                indice = al.size() - 1;
                suma += numero;
                System.out.printf("Hilo %s, introduce el valor %d en la posición %d, Array = %s, Suma=%d \n",
                        nombre, numero, indice, al, suma);
                sleep(1000);
            }else{
                wait();
            }
        }

    }

    public synchronized void saleNumero(String nombre) throws InterruptedException {

        do {
            indice = al.size() - 1;
            numero = al.get(indice);
            al.remove(indice);

            //}
            suma -= numero;
            System.out.printf("Hilo %s, saca el valor %d en la posición %d, Array = %s, Suma=%d \n",
                    nombre, numero, indice, al, suma);
            sleep(1500);

        } while (!al.isEmpty());
    }

    public synchronized void finaliza() {
        notify();
    }
}
