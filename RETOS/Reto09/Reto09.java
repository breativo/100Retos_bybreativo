package RETOS.Reto09;

import java.util.Random;

public class Reto09 {
/*
* Desarrolla un programa que determine quién gana más partidas en el juego "Piedra, Papel o Tijera". El resultado final puede ser "Jugador 1", "Jugador 2" o "Empate". La función debe recibir como entrada una lista de pares, donde cada par representa una jugada realizada por el Jugador 1 y el Jugador 2. Cada jugada se representará mediante las siguientes opciones:

    *"Piedra"
    *"Papel"
    *"Tijera"

*El programa debe comparar las jugadas de cada par, determinar el ganador de cada partida, contabilizar las victorias de cada jugador, y finalmente devolver quién ganó más partidas, o si hubo un empate.

*Ejemplo de Entrada:

*[("Piedra", "Tijera"), ("Tijera", "Piedra"), ("Papel", "Tijera")]

*Pistas:
*Recuerda las reglas básicas del juego: Piedra vence a Tijera, Tijera vence a Papel, y Papel vence a Piedra.
*/


	static int contador= 0;
	static int partidas= 7;
	static int contadorj1 = 0, contadorj2 = 0;
	
	public static void main(String[] args) {
		String [] jugada = {"piedra", "papel", "tijera"};
		Random random = new Random();
		
		do {
		int usuario = random.nextInt(jugada.length);
		int oponente = random.nextInt(jugada.length);
		contador++;
		
		System.out.println("Usuario: "  +  jugada[usuario]);
		System.out.println("Oponente: "  + jugada[oponente]);
		
		 // Comparar las jugadas para determinar el ganador
        if (usuario == oponente) {
            System.out.println("¡Es un empate!");
        } else if ((usuario == 0 && oponente == 2) || // Piedra gana a Tijera
                   (usuario == 1 && oponente == 0) || // Papel gana a Piedra
                   (usuario == 2 && oponente == 1)) { // Tijera gana a Papel
            System.out.println("Usuario gana!");
            contadorj1++;
        } else {
            System.out.println("Contrario gana!");
            contadorj2++;
        };
        System.out.println("");
        
        if(contadorj1 > 2) {
        System.out.println("Ganador final el Usuario!🎉🎉🎉");
    	break;
        };
        if(contadorj2 > 2) {
        System.out.println("Ganador final el Oponente!🎉🎉🎉");
    	break;
        };
    
		}while(contador < partidas );
        System.out.println("Partida terminada");
	}
}
