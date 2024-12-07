package RETOS.Reto27;

import java.util.*;

/*
 *  Crea un programa que simule un juego de bingo en el que los cartones tienen un formato 5x1 (5 columnas y 1 filas).
 *  Los números en los cartones y las extracciones se generan en el rango de 1 a 50. El objetivo es que los jugadores 
 *  compitan hasta que uno logre tachar todos los números de su cartón.
 */
public class Reto27 {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego de Bingo!");
        System.out.print("Ingrese el número de jugadores: ");
        int numJugadores = scanner.nextInt();
        scanner.nextLine(); 

        List<String> jugadores = new ArrayList<>();
        Map<String, String[]> cartones = new HashMap<>();

        for (int i = 0; i < numJugadores; i++) {
            System.out.print("Nombre del jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            jugadores.add(nombre);
            cartones.put(nombre, generarCarton());
        }

        System.out.println("\nCartones generados:");
        for (String jugador : jugadores) {
            System.out.println(jugador + ": " + Arrays.toString(cartones.get(jugador)));
        }

        System.out.println("\n¡Comienza el juego!");
        Set<Integer> numerosCantados = new HashSet<>();
        boolean hayGanador = false;

        while (!hayGanador) {
            int numero;
            do {
                numero = new Random().nextInt(51); 
            } while (numerosCantados.contains(numero));
            numerosCantados.add(numero);

            System.out.println("\nNúmero cantado: " + numero);

            for (String jugador : jugadores) {
                String[] carton = cartones.get(jugador);
                boolean tieneNumero = false;

                for (int i = 0; i < carton.length; i++) {
                    if (carton[i].equals(String.valueOf(numero))) {
                        carton[i] = "X"; 
                        System.out.println(jugador + " tiene el número " + numero + " en su cartón.");
                        tieneNumero = true;
                    }
                }

                if (!tieneNumero) {
                    System.out.println(jugador + " no tiene el número " + numero + ".");
                }

                if (esGanador(carton)) {
                    System.out.println("\n¡" + jugador + " ha hecho Bingo y es el ganador!");
                    hayGanador = true;
                    break;
                }
            }

            if (!hayGanador) {
                System.out.println("\nEstado de los cartones:");
                for (String jugador : jugadores) {
                    System.out.println(jugador + ": " + Arrays.toString(cartones.get(jugador)));
                }

                Thread.sleep(10000);
            }
        }

        System.out.println("¡Gracias por jugar al Bingo!");
    }

    public static String[] generarCarton() {
        Random random = new Random();
        String[] carton = new String[5];
        carton[0] = String.valueOf(random.nextInt(11)); 
        carton[1] = String.valueOf(random.nextInt(10) + 11); 
        carton[2] = String.valueOf(random.nextInt(10) + 21); 
        carton[3] = String.valueOf(random.nextInt(10) + 31); 
        carton[4] = String.valueOf(random.nextInt(10) + 41); 
        return carton;
    }

    public static boolean esGanador(String[] carton) {
        for (String num : carton) {
            if (!num.equals("X")) {
                return false;
            }
        }
        return true;
    }
}
