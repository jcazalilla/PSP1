/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Actividad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Jesús Cazalilla
 */
public class cadenas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String[] SILABAS = {
            "ba", "be", "bi", "bo", "bu",
            "ca", "ce", "ci", "co", "cu",
            "da", "de", "di", "do", "du",
            "fa", "fe", "fi", "fo", "fu",
            "ga", "ge", "gi", "go", "gu",
            "ma", "me", "mi", "mo", "mu",
            "pa", "pe", "pi", "po", "pu",
            "ra", "re", "ri", "ro", "ru",
            "ta", "te", "ti", "to", "tu",
            "za", "ze", "zi", "zo", "zu"
        };
        //pedimos por consola la cantidad de cadenas a generar
        Scanner sc = new Scanner(System.in);
        int numCadenas = 0;
        try {
            System.err.printf("Introduce la cantidad de cadenas que quieres formar: \n");
            numCadenas = sc.nextInt();
        } catch (InputMismatchException ex) {
            System.err.println("Formato erróneo, debes introducir un número.");
        }

        //lista para almacenar las cadenas generadas
        ArrayList<String> cadenas = new ArrayList<>();

        //bucle que genera nº de cadenas de longitud aleatoria entre 1 y 10
        for (int i = 0; i < numCadenas; i++) {
            int longitudCadena = (int) (Math.random() * 10 + 1);

            String aux = ""; //auxiliar para almacenar cadenas temporales

            //generamos longitud máxima de 10 carácteres
            for (int j = 0; j < longitudCadena / 2; j++) {
                //seleccionamos aleatoriamente componentes del array 0..49
                aux += SILABAS[(int) (Math.random() * 50)];
            }
            //si la parte entera de la división es cero nos aseguramos una sílaba
            if (longitudCadena / 2 == 0) {
                //seleccionamos aleatoriamente componentes del array 0..49
                aux += SILABAS[(int) (Math.random() * 50)];
            }
            cadenas.add(aux);
        }
        try {
            for (String elemento : cadenas) {

                //instanciamos un proceso para cada elemento del ArrayList
                Process p = Runtime.getRuntime().exec("java frecuencia");
                //Realiza la tubería con la clase BufferedReader, tomando del proceso
                //los datos con el método getInputStream
                InputStream is = p.getInputStream();
                BufferedReader bfr = new BufferedReader(new InputStreamReader(is));
                //Cada línea de consola será recogida por la clase frecuencia.java,
                //realizando la tubería

                System.out.println(elemento);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
