import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Reto17 {
    
    /*
* Desarrollar un programa que seleccione una palabra aleatoria de un archivo de texto (.txt) y oculte el 50% de las letras de la palabra. 
* El usuario deberá adivinar las letras faltantes, teniendo un máximo de 2 errores permitidos. Si introduce una letra incorrecta por tercera vez, perderá el juego.

* Descripción del Ejercicio:

* - El programa leerá un archivo de texto (palabras.txt) que contiene una lista de palabras (una palabra por línea).
* - Seleccionará aleatoriamente una palabra del archivo.
* - Ocultará el 50% de las letras de la palabra seleccionada, mostrando los espacios en blanco como guiones bajos (_).
*/

    public static void main(String[] args) throws IOException {
        List<String> palabras = leerPalabras("RETOS\\Reto17\\palabras.txt");
        String palabra = palabras.get(new Random().nextInt(palabras.size()));
        Set<Character> letrasErroneas = new HashSet<>();
        Set<Character> letrasAdivinadas = new HashSet<>();
        int errores = 0;

        String palabraOculta = ocultarPalabra(palabra);
        System.out.println("Palabra: " + palabraOculta); // Muestra la palabra con 50% visible

        Scanner scanner = new Scanner(System.in);
        while (errores < 2) {
            System.out.print("Introduce una letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);

            if (palabra.indexOf(letra) >= 0) {
                letrasAdivinadas.add(letra);
                System.out.println("¡Bien! Has acertado la letra: " + letra);
            } else {
                if (!letrasErroneas.contains(letra)) {
                    letrasErroneas.add(letra);
                    errores++;
                    System.out.println("¡Fallaste! Letras incorrectas: " + letrasErroneas);
                } else {
                    System.out.println("Ya has intentado la letra: " + letra);
                }
            }

            String palabraMostrada = mostrarPalabra(palabra, letrasAdivinadas);
            System.out.println("Palabra: " + palabraMostrada);

            if (palabraMostrada.equals(palabra)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabra);
                return;
            }
        }

        System.out.println("Has perdido. La palabra era: " + palabra);
    }

    public static List<String> leerPalabras(String nombreArchivo) throws IOException {
        List<String> palabras = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                palabras.add(linea.trim());
            }
        }
        return palabras;
    }

    public static String ocultarPalabra(String palabra) {
        int longitud = palabra.length();
        int numAOcultar = longitud / 2;
        Random random = new Random();
        Set<Integer> indicesOcultos = new HashSet<>();

        while (indicesOcultos.size() < numAOcultar) {
            indicesOcultos.add(random.nextInt(longitud));
        }

        StringBuilder oculta = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            if (indicesOcultos.contains(i)) {
                oculta.append('_');
            } else {
                oculta.append(palabra.charAt(i));
            }
        }

        return oculta.toString();
    }

    public static String mostrarPalabra(String palabra, Set<Character> letrasAdivinadas) {
        StringBuilder mostrada = new StringBuilder();
        for (char letra : palabra.toCharArray()) {
            if (letrasAdivinadas.contains(letra)) {
                mostrada.append(letra);
            } else {
                mostrada.append('_');
            }
        }
        return mostrada.toString();
    }
}
