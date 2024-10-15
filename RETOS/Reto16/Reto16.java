package RETOS.Reto16;

import java.util.Scanner;

public class Reto16 {
    /*
    * Desarrolla un programa que simule un juego de cartas en el que participan el usuario contra a maquina. El jugador principal deberá introducir su nombre para jugar contra el sistema. El objetivo es acercarse lo más posible a 21 puntos sin pasarse.

    * Reglas del juego:

    * - Cada jugador comienza con una mano vacía y va recibiendo cartas una por una.
    * - El valor de las cartas numéricas (2-10) es el mismo que el número de la carta.
    * - Las figuras (J, Q, K) valen 10 puntos cada una.
    * - El As (A) vale 1 punto.
    * - Los jugadores pueden elegir si desean recibir más cartas o plantarse en cualquier momento.
    * - El juego finaliza cuando todos los jugadores se plantan o cuando un jugador supera los 21 puntos, en cuyo caso queda eliminado.

    *Objetivo:

    * - El jugador que quede más cerca de 21 puntos sin pasarse es el ganador.
    * - Si todos los jugadores se pasan, no hay ganador.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerScore = 0, machineScore = 0;
        boolean playerStand = false, machineStand = false;

        System.out.print("Introduce tu nombre: ");
        String name = scanner.nextLine();

        while (!playerStand || !machineStand) {
            if (!playerStand) {
                System.out.print("\n¿Quieres sacar una carta? (s/n): ");
                String answer = scanner.nextLine().toLowerCase();
                if (answer.equals("n")) {
                    playerStand = true;
                } else {
                    int card = getRandomCard();
                    playerScore += card;
                    System.out.println("Has sacado un " + card + ". Total: " + playerScore);
                    if (playerScore > 21) {
                        System.out.println(name + ", tu total es " + playerScore + ". Has perdido.");
                        scanner.close();
                        return;
                    }
                }
            }

            if (!machineStand) {
                if (machineScore < 17) {
                    int card = getRandomCard();
                    machineScore += card;
                    System.out.println("La máquina ha sacado un " + card + ". Total de la máquina: " + machineScore);
                    if (machineScore > 21) {
                        System.out.println("La máquina ha perdido. ¡Has ganado!");
                        scanner.close();
                        return;
                    }
                } else {
                    machineStand = true;
                    System.out.println("La máquina se planta.");
                }
            }
        }

        determineWinner(name, playerScore, machineScore);
        scanner.close();
    }

    private static int getRandomCard() {
        return Math.min((int) (Math.random() * 13) + 1, 10);
    }

    private static void determineWinner(String name, int playerScore, int machineScore) {
        System.out.println("\nPuntuación final: " + name + ": " + playerScore + ", Máquina: " + machineScore);
        if (playerScore > machineScore) {
            System.out.println("\n¡Has ganado, " + name + "!");
        } else if (machineScore > playerScore) {
            System.out.println("\nLa máquina ha ganado.");
        } else {
            System.out.println("\nEs un empate.");
        }
    }
}
