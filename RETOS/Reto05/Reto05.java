package RETOS.Reto05;

import java.util.Random;

/*
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien gane cada punto del juego.
 * 
 * - Las puntuaciones de un juego son 00, 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - 00
 *   30 - 00
 *   30 - 15
 *   30 - 30
 *   40 - 30
 *   Deuce
 *   Ventaja P1
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.   
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.   
 */
public class Reto05 {
    
    public static void main(String[] args) {
        puntuacionTenis(15);
    }

public static void puntuacionTenis(int cantidadPuntos){
    String[] puntuacion = {"00", "15", "30", "40"};
        int p1 = 0;
        int p2 = 0;
        String ventaja = "";

        Random random = new Random();

        for (int i = 0; i < cantidadPuntos; i++) {
            String puntoGanado = random.nextBoolean() ? "P1" : "P2";

            //Verificar si alguno de los jugadores ha ganado con la condición de 5 puntos
            if(p1 == 5 && p2<=3){
                System.out.println("Ha ganado el P1");
                return;
            }

            if(p2 == 5 && p1<=3){
                System.out.println("Ha ganado el P2");
                return;
            }
            // Incrementar la puntuación del jugador que ganó el punto
            if (puntoGanado.equals("P1")) p1++;
            else if (puntoGanado.equals("P2")) p2++;

            // Determinar el estado del juego
            if (p1 >= 4 || p2 >= 4) {
                if (p1 == p2) {
                    // Regresar a "Deuce" si el puntaje está empatado después de 40
                    System.out.println("Deuce");
                    ventaja = "";
                } else if (p1 == p2 + 1) {
                    // Ventaja para P1
                    System.out.println("Ventaja P1");
                    ventaja = "P1";
                } else if (p2 == p1 + 1) {
                    // Ventaja para P2
                    System.out.println("Ventaja P2");
                    ventaja = "P2";
                } else if (p1 >= p2 + 2 && ventaja.equals("P1")) {
                    // Ganador P1
                    System.out.println("Ha ganado el P1");
                    return;
                } else if (p2 >= p1 + 2 && ventaja.equals("P2")) {
                    // Ganador P2
                    System.out.println("Ha ganado el P2");
                    return;
                }
            } else {
                // Mostrar la puntuación habitual antes de llegar a "40"
                System.out.println(puntuacion[Math.min(p1, 3)] + " - " + puntuacion[Math.min(p2, 3)]);
            }
        }

        // En caso de que haya "Ventaja" y luego se empate de nuevo
        if (p1 >= 3 && p2 >= 3 && !ventaja.isEmpty() && p1 == p2) {
            System.out.println("Deuce");
        }
    }
}

