package RETOS.Reto02;
import java.util.Scanner;
public class Reto02 {
/*
 * Escribe un programa que reciba un solo carácter por parte del usuario y muestre por consola (con un print) si dicho carácter es una vocal o una consonante. Si el carácter no es una letra, el programa deberá mostrar un mensaje de error.
 *
 * - Si el carácter es una vocal, mostrará: "Es una vocal".
 * - Si el carácter es una consonante, mostrará: "Es una consonante".
 * - Si el carácter no es una letra (números, símbolos, espacios, etc.), mostrará: "Error: No es una letra".
 *
 *El programa debe funcionar tanto para letras mayúsculas como minúsculas.
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un solo carácter: ");
        String input = scanner.nextLine();

        // Verificar que se ingresó un solo carácter
        if (input.length() != 1) {
            System.out.println("Error: Se debe ingresar solo un carácter.");
            return;
        }

        char caracter = input.charAt(0);

        // Convertir a minúscula para simplificar la comparación
        char c = Character.toLowerCase(caracter);

        // Verificar si es una letra
        if (Character.isLetter(c)) {
            if ("aeiou".indexOf(c) >= 0) {
                System.out.println("Es una vocal.");
            } else {
                System.out.println("Es una consonante.");
            }
        } else {
            System.out.println("Error: No es una letra.");
        }
    }
}
