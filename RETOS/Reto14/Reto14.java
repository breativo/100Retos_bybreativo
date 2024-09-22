package RETOS.Reto14;

import java.util.Scanner;

public class Reto14 {
    
/*
 * Crea un programa que cuente el número de vocales en una frase ingresada por el usuario. El programa debe seguir estas reglas:

* - Solicitar al usuario que ingrese una frase. La frase puede contener letras mayúsculas y minúsculas.
* - Preguntar al usuario si quiere contar:
        
       * Todas las vocales (a, e, i, o, u).
       *  Una vocal específica (el usuario debe ingresar cuál vocal desea contar).

* - Contar el número de vocales según la elección del usuario. No debe diferenciar entre mayúsculas y minúsculas.
* - Mostrar el resultado al usuario. Indicar cuántas vocales se encontraron en la frase, según la opción elegida.

* Consideraciones Adicionales:

* - El programa debe manejar frases vacías y mostrar un mensaje adecuado si no se encuentran vocales. 
 */

      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String frase = scanner.nextLine();

        System.out.print("¿Quieres contar todas las vocales o una vocal específica? (todas/vocal): ");
        String tipo = scanner.nextLine();

        int contador = 0;

        if (tipo.equalsIgnoreCase("todas")) {
            for (char c : frase.toCharArray()) {
                if ("aeiouAEIOU".indexOf(c) != -1) {
                    contador++;
                }
            }
            System.out.println("El número total de vocales en la frase es: " + contador);
        } else if (tipo.equalsIgnoreCase("vocal")) {
            System.out.print("¿Cuál vocal deseas contar? (a/e/i/o/u): ");
            char vocal = scanner.nextLine().charAt(0);
            for (char c : frase.toCharArray()) {
                if (Character.toLowerCase(c) == Character.toLowerCase(vocal)) {
                    contador++;
                }
            }
            System.out.println("El número de '" + vocal + "' en la frase es: " + contador);
        } else {
            System.out.println("Opción no válida.");
        }
        
        scanner.close();
    }
}
