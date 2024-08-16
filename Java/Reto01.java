package Java;

import java.util.Arrays;

/*
    Reto #1
    ¿ES UN ANAGRAMA?
    Dificultad: MEDIA

    Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
-Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
-NO hace falta comprobar que ambas palabras existan.
-Dos palabras exactamente iguales no son anagrama.
 */
public class Reto01 {
    public static void main(String[] args) {
      System.out.println(esAnagrama("amor", "roma"));
      System.out.println(esAnagrama("amor", "corazon"));
    }


    public static boolean esAnagrama(String palabra1, String palabra2) {
        // Convertir ambas palabras a minúsculas
        palabra1 = palabra1.toLowerCase();
        palabra2 = palabra2.toLowerCase();

        // Si las palabras son exactamente iguales, no son anagramas
        if (palabra1.equals(palabra2)) {
            return false;
        }

        // Verificamos si tienen la misma longitud
        if (palabra1.length() != palabra2.length()) {
            return false;
        }

        // Convertimos las palabras en arrays de caracteres, las ordenamos y las comparamos
        char[] array1 = palabra1.toCharArray();
        char[] array2 = palabra2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }
}
