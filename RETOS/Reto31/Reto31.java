package RETOS.Reto31;


 // Solución en Java
import java.util.*;

public class Reto31 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] icons = {"🍒", "🔔", "🍋", "💎", "⭐", "🎲", "🌈", "🔥", "🍉", "🌟"};
        int coins = 25;
        int totalGames = 0;
        int wins = 0;
        int totalCoinsWon = 0;
        int longestLosingStreak = 0;
        int currentLosingStreak = 0;
        int wildcardWins = 0;

        System.out.println("Bienvenido a la Máquina Tragaperras con Comodín");
        System.out.println("Comienzas con " + coins + " monedas. ¡Buena suerte!\n");

        while (coins > 0) {
            System.out.println("Presiona 'a' para jugar o 'b' para salir.");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("b")) {
                printStats(totalGames, totalCoinsWon, wins, wildcardWins, longestLosingStreak);
                break;
            } else if (choice.equals("a")) {
                coins--;
                totalGames++;

                Random random = new Random();
                String[] result = {
                    icons[random.nextInt(icons.length)],
                    icons[random.nextInt(icons.length)],
                    icons[random.nextInt(icons.length)]
                };

                System.out.println("Resultado: " + String.join(" ", result));

                boolean isWin = false;
                if (result[0].equals(result[1]) && result[1].equals(result[2])) {
                    isWin = true;
                } else if (Arrays.asList(result).contains("🎲") &&
                           (result[0].equals(result[1]) || result[1].equals(result[2]) || result[0].equals(result[2]))) {
                    isWin = true;
                    wildcardWins++;
                }

                if (isWin) {
                    int coinsWon = coins;
                    coins += coinsWon;
                    totalCoinsWon += coinsWon;
                    wins++;
                    currentLosingStreak = 0;
                    System.out.println("¡Ganaste! Has ganado " + coinsWon + " monedas. Tu saldo es de " + coins + " monedas.\n");
                } else {
                    currentLosingStreak++;
                    longestLosingStreak = Math.max(longestLosingStreak, currentLosingStreak);
                    System.out.println("No hubo acierto. Te quedan " + coins + " monedas.\n");
                }
            } else {
                System.out.println("Opción no válida. Intenta nuevamente.");
            }
        }

        if (coins == 0) {
            System.out.println("Te has quedado sin monedas. Fin del juego.");
            printStats(totalGames, totalCoinsWon, wins, wildcardWins, longestLosingStreak);
        }

        scanner.close();
    }

    private static void printStats(int totalGames, int totalCoinsWon, int wins, int wildcardWins, int longestLosingStreak) {
        System.out.println("\nJuego terminado. Estas son tus estadísticas:");
        System.out.println("Jugadas realizadas: " + totalGames);
        System.out.println("Monedas ganadas: " + totalCoinsWon);
        System.out.println("Monedas gastadas: " + totalGames);
        System.out.println("Aciertos logrados: " + wins);
        System.out.println("Combinaciones con comodín: " + wildcardWins);
        System.out.println("Racha más larga sin aciertos: " + longestLosingStreak);
    }
}

