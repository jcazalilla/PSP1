/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Actividad1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Jesús Cazalilla
 */
public class frecuencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena="";
        /*
        Para utilizar tuberías, la clase que va a recibir el flujo de información, debe instanciar la clase BufferedReader, a partir de una instancia de InputStreamReader. Estas clases permitirán leer contenidos desde teclado (como la extendida clase Scanner) pero además, recibir información que se muestra en pantalla como salida de otro proceso (implementando así la tubería).
         */
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(isr);

        try {
            while ((cadena=bfr.readLine())!= null && !cadena.isEmpty()) {

                int vecesA = 0, vecesE = 0, vecesI = 0, vecesO = 0, vecesU = 0;

                for (int i = 0; i < cadena.length(); i++) {

                    switch (cadena.charAt(i)) {
                        case 'a':
                            vecesA++;
                            break;
                        case 'e':
                            vecesE++;
                            break;
                        case 'i':
                            vecesI++;
                            break;
                        case 'o':
                            vecesO++;
                            break;
                        case 'u':
                            vecesU++;
                            break;
                        default:
                            break;
                    }
                }

                System.out.printf("cadena: %s --> %d %d %d %d %d \n",
                        cadena, vecesA, vecesE, vecesI, vecesO, vecesU);
            }
        } catch (IOException ex) {
            System.err.println("Error de entrada de datos. Dato no válido");
        }

    }
}
