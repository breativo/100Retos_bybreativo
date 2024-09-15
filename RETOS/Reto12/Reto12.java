package RETOS.Reto12;

import java.util.Random;
import java.util.Scanner;

public class Reto12 {
/*
 * Crea un programa que simule un juego para encontrar un número oculto. El programa debe seguir las siguientes reglas:

* El número oculto será un número entero aleatorio entre 0 y 100.
* El usuario tendrá 5 vidas al comenzar el juego.
* En cada intento, el usuario debe ingresar un número entre 0 y 100.
* Si el número ingresado no es correcto:
       * - El programa restará 1 vida.
       * - El programa dará una pista, indicando si el número oculto es más alto o más bajo que el número ingresado.
* Si el usuario agota las 5 vidas, el programa mostrará un mensaje de "¡Has perdido!" y revelará el número oculto.
* Si el usuario adivina el número oculto antes de quedarse sin vidas, el programa mostrará un mensaje de "¡Has ganado!".

* Consideraciones adicionales:

* El programa debe validar que el número ingresado por el usuario esté dentro del rango permitido (0 - 100). Si el usuario introduce un número fuera del rango, deberá volver a solicitarlo sin penalizar vidas.
* Cada vez que el usuario pierda una vida, el programa debe mostrar cuántas vidas le quedan.
* Cuando el usuario gane o pierda, el programa deberá terminar indicando el número oculto y la cantidad de intentos utilizados (si ganó).
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numeroOculto = random.nextInt(101);
        int vidas = 5;
        int intentos = 0;

        System.out.println("El número oculto está entre 0 y 100.");
        System.out.println("Tienes " + vidas + " vidas.");

        while (vidas > 0) {
            System.out.print("Introduce tu número: ");
            int intento = scanner.nextInt();
            intentos++;

            if (intento < 0 || intento > 100) {
                System.out.println("El número debe estar entre 0 y 100.");
                continue;
            }

            if (intento == numeroOculto) {
                System.out.println("¡Has adivinado el número oculto! ¡Has ganado en " + intentos + " intentos!");
                break;
            } else {
                vidas--;
                if (intento < numeroOculto) {
                    System.out.println("El número oculto es más alto.");
                } else {
                    System.out.println("El número oculto es más bajo.");
                }

                if (vidas > 0) {
                    System.out.println("Te quedan " + vidas + " vidas.");
                } else {
                    System.out.println("¡Has perdido! El número oculto era: " + numeroOculto);
                }
            }
        }
        scanner.close();
    }
}

