package RETOS.Reto19;

import java.text.Normalizer;
import java.util.Scanner;

public class Reto19{

    /*
    * Crea un programa que determine si un texto ingresado es un palíndromo.

    * El programa pedirá al usuario que ingrese una frase o palabra y verificará si es un palíndromo.

    * "Un palíndromo es una palabra o frase que se lee igual de izquierda a derecha que de derecha a izquierda, sin tener en cuenta espacios, signos de puntuación ni tildes."

    *Detalles de Implementación:

    * - Solicitar al usuario una frase o palabra.
    * - Procesar el texto para ignorar:
        * Espacios en blanco.
        * Signos de puntuación (ej., comas, puntos, signos de interrogación).
        * Tildes (considerando las letras acentuadas como sus equivalentes sin tilde).
    
    * - Comparar el texto procesado:
        * Si el texto es igual al leerlo de izquierda a derecha y de derecha a izquierda, es un palíndromo.
        * Si no, no es un palíndromo.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una frase o palabra: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("PALÍNDROMO");
        } else {
            System.out.println("NO ES PALÍNDROMO");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String text) {

        String cleanText = Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("[^a-zA-Z]", "")
                .toLowerCase();

        String reversedText = new StringBuilder(cleanText).reverse().toString();
        return cleanText.equals(reversedText);
    }
}
