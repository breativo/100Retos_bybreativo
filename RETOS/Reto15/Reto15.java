package RETOS.Reto15;

import java.util.Scanner;

public class Reto15 {

    /*
     * Crea un programa que dibuje una escalera en función del número de escalones proporcionado por el usuario. El programa debe seguir las siguientes reglas:

     * - Si el número de escalones es positivo, la escalera será ascendente de izquierda a derecha. Cada peldaño estará compuesto por un guion bajo (_) y una barra vertical (|), con un desplazamiento hacia la derecha en cada línea.
     * - Si el número de escalones es negativo, la escalera será descendente de izquierda a derecha. En este caso, cada peldaño estará compuesto por una barra vertical (|) y un guion bajo (_), con un desplazamiento hacia la derecha en cada línea.
     * - Si el número de escalones es cero, se dibujarán dos guiones bajos (__) en dos líneas diferentes.
     */
    public static void dibujarEscalera(int n) {
        if (n > 0) {
            // Escalera ascendente
            for (int i = 0; i < n; i++) {
                System.out.println(" ".repeat(n - i - 1) + "_|");
            }
        } else if (n < 0) {
            // Escalera descendente
            for (int i = 0; i < -n; i++) {
                System.out.println(" ".repeat(i) + "|_");
            }
        } else {
            // Caso especial para n == 0
            System.out.println("__");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escalones = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Introduce el número de escalones: ");
                escalones = Integer.parseInt(scanner.nextLine());
                entradaValida = true; // La entrada es válida, salimos del bucle
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número entero válido.");
            }
        }

        dibujarEscalera(escalones);
        scanner.close();
    }
}
