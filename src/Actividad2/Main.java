/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Actividad2;

import java.util.ArrayList;

/**
 *
 * @author Jesús Cazalilla
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws InterruptedException
     */
    public static void main(String[] args) {

        //creamos ArrayList para almacenar la producción y
        //consumo de los elementos de tipo entero.
        ArrayList<Integer> al = new ArrayList<>();

        //instanciación de los hilos e inicio de ejecución
        new Productor("Productor1", al).start();
        new Productor("Productor2", al).start();
        new Consumidor("Cosumidor", al).start();

    }
}
