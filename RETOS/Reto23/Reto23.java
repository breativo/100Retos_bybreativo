package RETOS.Reto23;

import java.util.Random;
import java.util.Scanner;

public class Reto23 {
    
    /*
* Crea un programa que simule una carrera de obstáculos para un único atleta, quien debe completar un circuito de 20 tramos. El circuito se genera aleatoriamente y contiene tramos de suelo ("_") y vallas ("|"). El atleta solo puede ingresar las acciones "run" para correr y "jump" para saltar.

* Circuito:

    *- El circuito consta de 20 tramos generados aleatoriamente. Cada tramo puede ser suelo ("_") o valla ("|") con una probabilidad de 50% para cada uno.

* Acciones del Atleta:

    * - El atleta solo puede ingresar "run" o "jump". Si escribe mal una acción o elige incorrectamente, se considera un fallo.

*Tiempo y Penalización:

    * - Cada tramo correcto añade 1 segundo al tiempo total.
    * - Cada fallo (acción incorrecta o error de escritura) añade una penalización de 2 segundos adicionales.
    *- Al finalizar el circuito, el programa muestra el tiempo total y el número de fallos cometidos.
*/
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        
        System.out.print("Ingrese el nombre del atleta: ");
        String nombre = sc.nextLine();

        
        String circuito = generarPista(rand);
        System.out.println("Circuito generado: " + circuito);

        
        int tiempoTotal = 0;
        int fallos = 0;

    
        for (int i = 0; i < 20; i++) {
            char tramo = circuito.charAt(i);
            System.out.print("Tramo " + (i+1) + " (" + (tramo == '_' ? "suelo" : "valla") + "): ");
            String accion = sc.nextLine().trim().toLowerCase();

            if ((tramo == '_' && accion.equals("run")) || (tramo == '|' && accion.equals("jump"))) {
                tiempoTotal += 1;  
            } else {
                tiempoTotal += 3; 
                fallos += 1;
            }
        }

        
        System.out.println("Tiempo total de " + nombre + ": " + tiempoTotal + " segundos");
        System.out.println("Fallos de " + nombre + ": " + fallos);
    }

    
    private static String generarPista(Random rand) {
        StringBuilder pista = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            pista.append(rand.nextBoolean() ? '_' : '|');
        }
        return pista.toString();
    }
}
