/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Actividad2;

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

    public void entraNumero(String nombre, ArrayList<Integer> al) {

        try {
            //abrimos fichero para grabar ejecución de hilos
            PrintWriter writer = new PrintWriter(new FileWriter(rutaFichero, true));
            writer.println("============================================================================");
            writer.println("################  Ejecución de hilos Productores  ##########################");
            writer.println("============================================================================");

            while (suma < 100) {

                //realizamos mutex sobre el recurso a compartir ArrayList (al)
                synchronized (al) {

                    //Producimos números mientras no llenemos la lista con mas de 10 elementos
                    if (al.size() < 10) {
                        //generamos aleatoriamente un entero entre 0 y 10
                        numero = (int) (Math.random() * 11);
                        //añadimos el número a la lista
                        al.add(numero);
                        //anotamos el índice para más adelante mostrar información
                        //de la posición en que hemos añdadido el nº
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
            //dormimos el hilo
            sleep(100);
            //cerramos fichero en el que grabamos ejecución del hilo.
            writer.close();

            //gestionamos errores de fichero e hilo
        } catch (IOException ex) {
            System.out.println("Error de fichero.... no encontrado \"hilos.txt\"");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saleNumero(String nombre, ArrayList<Integer> al) {
        try {
            //abrimos fichero para grabar ejecución de hilos
            PrintWriter writer = new PrintWriter(new FileWriter(rutaFichero, true));
            writer.println("============================================================================");
            writer.println("###############  Ejecución de hilos Consumidores  ##########################");
            writer.println("============================================================================");

            while (suma < 100) {

                //realizamos mutex sobre el recurso a compartir ArrayList (al)
                synchronized (al) {

                    // si no está vacio puede sacar números
                    if (!al.isEmpty()) {
                        //nos quedamos con el índice de la última posción antes de consumir
                        indice = al.size() - 1;
                        //copiamos en la variable numero el valor de la última poscion.
                        numero = al.get(indice);
                        //consumimos el valor de la última posición.
                        al.remove(indice);
                        //sumamos el valor que consumimos a la variable suma (suma total consumida)
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
            //dormimos el hilo
            sleep(150);
            //gestionamos los errores de fichero e hilo
            writer.close();

            //gestionamos errores de fichero e hilo.
        } catch (IOException ex) {
            System.out.println("Error de fichero.... no encontrado \"hilos.txt\"");
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
