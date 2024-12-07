package RETOS.Reto26;

import java.util.*;

/*
 * Crea un programa que simule un sorteo de rifa basado en números aleatorios.
 * El usuario solo debe proporcionar los parámetros necesarios, y el programa 
 * realizará automáticamente el sorteo.
 */
public class Reto26 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("¡Bienvenido al sorteo de la suerte!");
        System.out.print("Ingresa el número inicial del rango: ");
        int inicio = scanner.nextInt();

        System.out.print("Ingresa el número final del rango: ");
        int fin = scanner.nextInt();


        if (inicio >= fin) {
            System.out.println("El número inicial debe ser menor que el número final.");
            return;
        }

        System.out.print("Ingresa la cantidad de ganadores: ");
        int ganadores = scanner.nextInt();

        if (ganadores > (fin - inicio + 1)) {
            System.out.println("La cantidad de ganadores no puede ser mayor que el rango de números.");
            return;
        }

        Random random = new Random();
        Set<Integer> ganadoresSet = new HashSet<>();

        while (ganadoresSet.size() < ganadores) {
            int numero = random.nextInt(fin - inicio + 1) + inicio;
            ganadoresSet.add(numero);
        }

        System.out.println("\nSimulando el sorteo...");
        System.out.println("🎉 Los números ganadores son: ");
        for (int numero : ganadoresSet) {
            System.out.println("   - " + numero);
        }

        System.out.println("\n¡Gracias por participar en el sorteo de la rifa!");
    }
}
