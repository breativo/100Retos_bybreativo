package RETOS.Reto07;

import java.util.Scanner;

public class Reto07 {
/*
 * Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
 *
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una cadena de texto: ");
        String texto = scanner.nextLine();
        
        // Convertir la cadena en un arreglo de caracteres
        char[] caracteres = texto.toCharArray();
        int longitud = caracteres.length;

        // Invertir el arreglo de caracteres
        for (int i = 0; i < longitud / 2; i++) {
            char temp = caracteres[i];
            caracteres[i] = caracteres[longitud - 1 - i];
            caracteres[longitud - 1 - i] = temp;
        }

        // Convertir el arreglo de caracteres de nuevo en una cadena
        String textoInvertido = new String(caracteres);
        System.out.println("Cadena invertida: " + textoInvertido);
    }
}
