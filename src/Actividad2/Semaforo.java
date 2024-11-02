/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Thread.sleep;
import java.util.ArrayList;

/**
 *
 * @author Jesús Cazalilla
 */
public class Semaforo {

    //variable para alamacenar la suma de los
    //números consumidos del array.
    static private int suma = 0;
    private int indice = 0;//índice del array
    private int numero = 0;//número a producir o sacado del array
    //ruta del fichero donde grabaremos la ejecuicón de los hilos
    String rutaFichero = System.getProperty("user.dir") + "/recursos/hilos.txt";

    public  void entraNumero(String nombre, ArrayList<Integer> al) throws InterruptedException {
        System.out.println("Fichero abierto para grabación de hilos producotores.");

        try {

            PrintWriter writer = new PrintWriter(new FileWriter(rutaFichero, true));
            writer.println("============================================================================");
            writer.println("################  Ejecución de hilos Productores  ##########################");
            writer.println("============================================================================");
            while (suma <= 100) {

                synchronized (al) {
                    if (al.size() < 10) {
                        numero = (int) (Math.random() * 11);// aleatorio de 0..10
                        al.add(numero);
                        indice = al.size() - 1;
                        //imprimimos por consola
                        System.out.printf("Hilo %s, introduce el valor %d en la posición %d, Array = %s, Suma=%d \n",
                                nombre, numero, indice, al, suma);
                        //grabamos en fichero
                        writer.printf("Hilo %s, introduce el valor %d en la posición %d, Array = %s, Suma=%d \n",
                                nombre, numero, indice, al, suma);
                    }
                }
            }
            sleep(100);
            writer.close();System.out.println("Fichero cerrado después de grabación hilos productores.");
            
        } catch (IOException ex) {
            System.out.println("Error de fichero.... no encontrado \"hilos.txt\"");
        }
    }

    public void saleNumero(String nombre, ArrayList<Integer> al) throws InterruptedException {
        System.out.println("Fichero abierto para grabación de hilos conusmidores.");
        try {

            PrintWriter writer = new PrintWriter(new FileWriter(rutaFichero, true));
            writer.println("============================================================================");
            writer.println("###############  Ejecución de hilos Consumidores  ##########################");
            writer.println("============================================================================");

            while (suma <= 100) {

                synchronized (al) {
                    if (!al.isEmpty()) {
                        // si no está vacio puede sacar números
                        indice = al.size() - 1;
                        numero = al.get(indice);
                        al.remove(indice);
                        suma += numero;
                        //Imprimimos por consola
                        System.out.printf("Hilo %s, saca el valor %d en la posición %d, Array = %s, Suma=%d \n",
                                nombre, numero, indice, al, suma);
                        //grabamos en fichero
                        writer.printf("Hilo %s, saca el valor %d en la posición %d, Array = %s, Suma=%d \n",
                                nombre, numero, indice, al, suma);
                    }
                }
            }
            sleep(150);
            writer.close();
            System.out.println("Fichero cerrado después de grabación hilos consumidores");
        } catch (IOException ex) {
            System.out.println("Error de fichero.... no encontrado \"hilos.txt\"");
        }
    }

}
