package RETOS.Reto24;

import java.util.Random;
import java.util.Scanner;

public class Reto24 {
    
    /*
     * Crea un programa que simule una carrera de camellos en el que el usuario selecciona uno de los siete camellos
     * y los camellos avanzan de acuerdo con tiradas aleatorias. El primero que llegue a la meta (casilla 10) ganará
     * la carrera.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        
        int[] camellos = new int[7];
        for (int i = 0; i < 7; i++) {
            camellos[i] = 0; // Todos comienzan en la casilla 0
        }
        
        System.out.println("¡Bienvenido a la carrera de camellos!");
        System.out.print("Elige tu camello (1 a 7): ");
        int camelloElegido = scanner.nextInt() - 1;  
        
    
        int meta = 10;
        boolean carreraTerminada = false;
        
        while (!carreraTerminada) {
        
            for (int i = 0; i < 7; i++) {
                String carreraVisual = "-".repeat(camellos[i]) + (i + 1) + "".repeat(meta - camellos[i]);
                System.out.print(carreraVisual + " ");
            }
            System.out.println();
            
        
            for (int i = 0; i < 7; i++) {
                if (random.nextInt(7) == i) { 
                    camellos[i]++;
                }
            }
            
            
            for (int i = 0; i < 7; i++) {
                if (camellos[i] >= meta) {
                    System.out.println("¡El camello " + (i + 1) + " ha llegado a la meta!");
                    if (i == camelloElegido) {
                        System.out.println("¡Felicidades! Has ganado.");
                    } else {
                        System.out.println("¡Lo siento! Tu camello no ganó.");
                    }
                    carreraTerminada = true;
                    break;
                }
            }
        }
        scanner.close();
    }

}
