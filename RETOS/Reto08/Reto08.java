package RETOS.Reto08;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Reto08 {
    /*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa el texto:");
    String texto = scanner.nextLine().toLowerCase();

    // Eliminar signos de puntuación
    texto = texto.replaceAll("[^a-zA-Z\\s]", "");

    // Usar un HashMap para contar las palabras
    Map<String, Integer> contadorPalabras = new HashMap<>();

    // Tokenizar el texto en palabras
    StringTokenizer tokenizer = new StringTokenizer(texto);

    while (tokenizer.hasMoreTokens()) {
        String palabra = tokenizer.nextToken();
        contadorPalabras.put(palabra, contadorPalabras.getOrDefault(palabra, 0) + 1);
    }

    // Imprimir el recuento final
    for (Map.Entry<String, Integer> entry : contadorPalabras.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
    }
}
}
