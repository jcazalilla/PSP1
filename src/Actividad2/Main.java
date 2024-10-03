/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Actividad2;

/**
 *
 * @author Jesús Cazalilla
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Productor hiloP1 = new Productor("Productor1");
        Productor hiloP2 = new Productor("Productor2");

        Consumidor hiloC = new Consumidor("Cosumidor1");

        hiloP1.start();
        //hiloP1.join();
        hiloP2.start();
       // hiloP2.join();

        hiloC.start();
       // hiloC.join();

    }

}
