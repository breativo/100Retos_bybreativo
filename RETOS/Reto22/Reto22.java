package RETOS.Reto22;

import java.util.Random;
import java.util.Scanner;

public class Reto22 {

    /*
    * Desarrolla un programa de "Juego de Dados" estilo casino en el que el jugador comienza con 10 "patos" 
    * como fondos iniciales. El jugador puede apostar la cantidad de patos que desee en cada ronda, tratando 
    * de acertar la suma de los dos dados lanzados. El juego continúa hasta que el jugador se quede sin patos,
    * momento en el cual la partida termina automáticamente.
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int patos = 10;

        System.out.println("Bienvenido al Juego de Dados. ¡Tienes " + patos + " patos!");

        while (patos > 0) {
            System.out.println("Saldo actual: " + patos + " patos.");
            System.out.print("¿Cuántos patos deseas apostar? ");
            int apuesta = scanner.nextInt();

            if (apuesta > patos || apuesta <= 0) {
                System.out.println("Apuesta no válida. Inténtalo de nuevo.");
                continue;
            }

            System.out.print("Elige una suma entre 2 y 12: ");
            int sumaElegida = scanner.nextInt();

            if (sumaElegida < 2 || sumaElegida > 12) {
                System.out.println("Suma no válida. Inténtalo de nuevo.");
                continue;
            }

            int dado1 = random.nextInt(6) + 1;
            int dado2 = random.nextInt(6) + 1;
            int sumaDados = dado1 + dado2;

            System.out.println("Lanzaste los dados: Dado 1 = " + dado1 + ", Dado 2 = " + dado2 + ", Suma = " + sumaDados);

            if (sumaDados == sumaElegida) {
                patos += apuesta * 2;
                System.out.println("¡Felicidades, acertaste! Ganaste " + (apuesta * 2) + " patos.");
            } else {
                patos -= apuesta;
                System.out.println("No acertaste. Perdiste " + apuesta + " patos.");
            }
        }

        System.out.println("Lo siento, te has quedado sin patos. ¡La partida ha terminado!");
        scanner.close();
    }
}
