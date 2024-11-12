package RETOS.Reto21;

import java.util.Scanner;

public class Reto21 {

    /*
    * Crea un programa de cuenta atrás que permita al usuario seleccionar el tiempo en segundos, desde 10 segundos hasta 60 segundos en intervalos de 10 (es decir, 10, 20, 30, 40, 50, o 60 segundos).

    * Especificaciones:

    *- El programa debe mostrar un menú de selección de tiempo, ofreciendo las opciones: 10, 20, 30, 40, 50, o 60 segundos.
    *- El usuario seleccionará un valor para iniciar la cuenta atrás.
    *- Una vez que el usuario haya seleccionado el tiempo, el programa iniciará la cuenta atrás en tiempo real, mostrando el tiempo restante cada segundo hasta llegar a cero.
    *- Al finalizar, el programa mostrará un mensaje indicando que la cuenta atrás ha terminado.
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int[] opciones = {10, 20, 30, 40, 50, 60};
        int tiempoSeleccionado = 0;

        while (true) {
            System.out.println("Seleccione el tiempo de cuenta atrás: 10, 20, 30, 40, 50, o 60 segundos");
            tiempoSeleccionado = scanner.nextInt();

            if (isOpcionValida(tiempoSeleccionado, opciones)) break;
            System.out.println("Opción no válida. Intente de nuevo.");
        }

        System.out.println("Iniciando cuenta atrás de " + tiempoSeleccionado + " segundos...");
        for (int i = tiempoSeleccionado; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("¡Tiempo terminado!");
        scanner.close();
    }

    private static boolean isOpcionValida(int opcion, int[] opciones) {
        for (int o : opciones) {
            if (opcion == o) return true;
        }
        return false;
    }
}
