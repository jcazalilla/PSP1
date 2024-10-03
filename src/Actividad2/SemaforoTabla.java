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
public class SemaforoTabla {

    ArrayList<Integer> al;
    int suma = 0;

    public SemaforoTabla() {
        this.al = new ArrayList<>();
    }

    public synchronized void entraNumero(String nombre) throws InterruptedException {

        do {
            int numero = (int) (Math.random() * 11);//aleatorio de 0..10
            //no está lleno
            al.add(numero);
            suma += numero;
            System.out.printf("Hilo %s, introduce el valor %d en la posición %d, Array = %s, Suma=%d \n",
                    nombre, numero, al.size() - 1, al, suma);
            sleep(1000);
         
        } while (suma <= 100 && al.size() < 10);
        
    }

    public synchronized void saleNumero(String nombre) throws InterruptedException {

        int lastItem = 0;
        do {
            //if (!al.isEmpty() && suma <= 100) {
            int lastID = al.size() - 1;
            lastItem = al.get(lastID);
            al.remove(lastItem);

            //}
            suma -= lastItem;
             System.out.printf("Hilo %s, saca el valor %d en la posición %d, Array = %s, Suma=%d \n",
                    nombre, al.get(al.size()-1), al.size() - 1, al, suma);
             sleep(1500);
             
        } while (suma <= 100 && !al.isEmpty());
    }
}
