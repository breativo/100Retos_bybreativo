import java.io.*;
import java.util.*;

public class Reto13 {

    /*
    * Crea un programa que simule un sistema de sorteo para seleccionar ganadores de una lista de participantes almacenada en un archivo de texto plano (formato .txt). 

    * El programa debe seguir las siguientes reglas:

    * - El programa debe solicitar al usuario el nombre de un archivo de texto (.txt) que contenga una lista de nombres, donde cada nombre esté en una línea diferente. Si el archivo no existe, el programa debe mostrar un mensaje de error y solicitar nuevamente el archivo.
    * - Una vez cargado el archivo correctamente, el programa debe contar la cantidad total de participantes y mostrar este número al usuario.
    * - El programa debe preguntar cuántos ganadores desea seleccionar el usuario.
    * - El número de ganadores no puede ser mayor que el número de participantes. Si el número de ganadores es mayor, el programa debe mostrar un mensaje de error y solicitar nuevamente el número de ganadores.
    * - El programa debe seleccionar aleatoriamente a los ganadores de la lista, garantizando que no se repitan.
    * - Una vez realizado el sorteo, el programa debe mostrar los nombres de los ganadores.

    * Consideraciones adicionales:

    * - El archivo .txt debe tener un formato en el que cada nombre de participante esté en una línea distinta.
    * - El programa debe validar que el archivo de texto existe y contiene al menos un participante antes de continuar.
    * - Si el número de ganadores es válido, se deben seleccionar de manera aleatoria y sin repetición.
    * - Los nombres de los ganadores deben mostrarse en una lista ordenada.
    */
    public static List<String> cargarLista(String archivo) {
        List<String> nombres = new ArrayList<>();
        File file = new File(archivo);  

        System.out.println("Ruta absoluta del archivo: " + file.getAbsolutePath());  
        
        if (!file.exists()) {
            System.out.println("El archivo no existe en la ruta especificada.");
            return nombres;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                nombres.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        return nombres;
    }

    public static List<String> seleccionarGanadores(List<String> nombres, int numGanadores) {
        Collections.shuffle(nombres);
        return nombres.subList(0, numGanadores);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String archivo;
        List<String> nombres = new ArrayList<>();

        // Asegura que el archivo existe
        while (nombres.isEmpty()) {
            System.out.print("Introduce el nombre del archivo con la lista de participantes: ");
            // Introducir la url relativa del fichero txt.
            archivo = sc.nextLine();
            nombres = cargarLista(archivo);
        }

        System.out.println("Se han cargado " + nombres.size() + " participantes.");
        int numGanadores;

        while (true) {
            System.out.print("¿Cuántos ganadores deseas seleccionar? ");
            numGanadores = sc.nextInt();
            if (numGanadores > nombres.size()) {
                System.out.println("El número de ganadores no puede ser mayor al número de participantes.");
            } else {
                break;
            }
        }

        List<String> ganadores = seleccionarGanadores(nombres, numGanadores);
        System.out.println("\nLos ganadores seleccionados son:");
        for (int i = 0; i < ganadores.size(); i++) {
            System.out.println((i + 1) + ". " + ganadores.get(i));
        }
    }
}