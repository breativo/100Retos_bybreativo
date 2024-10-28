package RETOS.Reto18;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Reto18 {

    /*
     * Crea un programa que sea capaz de transformar texto natural a código Morse y viceversa, detectando automáticamente el tipo de entrada (texto o Morse) y realizando la conversión correspondiente.
     * Especificaciones:

     * - Detección automática: El programa debe identificar si el texto de entrada está en lenguaje natural o en código Morse y seleccionar el modo de conversión adecuado.

     * - Formato de Código Morse:
     *           Usa el alfabeto Morse estándar. 
     *           Para representar letras o símbolos, se debe usar una raya (—), un punto (.), un espacio simple ( ) entre letras y símbolos y dos espacios ( ) entre palabras.
     */

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el texto o código Morse: ");
        String input = scanner.nextLine();

        if (input.matches("[.\\- ]+")) {
            System.out.println("Morse a Texto: " + toText(input));
        } else {
            System.out.println("Texto a Morse: " + toMorse(input));
        }
        
    }

    private static final Map<String, String> morseToText = new HashMap<>();
    private static final Map<String, String> textToMorse = new HashMap<>();

    static {
        String[][] morseArray = {
            {"A", ".-"}, {"B", "-..."}, {"C", "-.-."}, {"D", "-.."}, {"E", "."},
            {"F", "..-."}, {"G", "--."}, {"H", "...."}, {"I", ".."}, {"J", ".---"},
            {"K", "-.-"}, {"L", ".-.."}, {"M", "--"}, {"N", "-."}, {"O", "---"},
            {"P", ".--."}, {"Q", "--.-"}, {"R", ".-."}, {"S", "..."}, {"T", "-"},
            {"U", "..-"}, {"V", "...-"}, {"W", ".--"}, {"X", "-..-"}, {"Y", "-.--"},
            {"Z", "--.."}, {"0", "-----"}, {"1", ".----"}, {"2", "..---"},
            {"3", "...--"}, {"4", "....-"}, {"5", "....."}, {"6", "-...."},
            {"7", "--..."}, {"8", "---.."}, {"9", "----."}
        };
        for (String[] pair : morseArray) {
            textToMorse.put(pair[0], pair[1]);
            morseToText.put(pair[1], pair[0]);
        }
    }

    public static String toMorse(String text) {
        StringBuilder morse = new StringBuilder();
        for (char c : text.toUpperCase().toCharArray()) {
            if (c == ' ') {
                morse.append("  ");
            } else {
                morse.append(textToMorse.getOrDefault(String.valueOf(c), "")).append(" ");
            }
        }
        return morse.toString().trim();
    }

    public static String toText(String morse) {
        StringBuilder text = new StringBuilder();
        String[] words = morse.split(" {2}");
        for (String word : words) {
            for (String symbol : word.split(" ")) {
                text.append(morseToText.getOrDefault(symbol, ""));
            }
            text.append(" ");
        }
        return text.toString().trim();
    }

}
