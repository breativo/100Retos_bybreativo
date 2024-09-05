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
import kotlin.random.Random

var contadorUsuario: Int = 0
var contadorOponente: Int = 0

fun main() {
    val partida = arrayOf("Piedra", "Papel", "Tijera")

    while (true) {
        // Obtener una selección aleatoria de usuario y oponente
        val usuario = Random.nextInt(partida.size)
        val oponente = Random.nextInt(partida.size)

        // Imprimir las opciones elegidas
        println("Usuario eligió: ${partida[usuario]}")
        println("Oponente eligió: ${partida[oponente]}")

        // Comparar las elecciones
        if (usuario == oponente) {
            println("¡Es un empate!")
        } else if (
            (partida[usuario] == "Piedra" && partida[oponente] == "Tijera") ||
            (partida[usuario] == "Papel" && partida[oponente] == "Piedra") ||
            (partida[usuario] == "Tijera" && partida[oponente] == "Papel")
        ) {
            println("¡Usuario gana!")
            contadorUsuario++
        } else {
            println("¡Oponente gana!")
            contadorOponente++
        }

        // Condición de victoria: el primero en llegar a 3 victorias
        if (contadorUsuario >= 3) {
            println("¡Ganador final: el Usuario! 🎉🎉🎉")
            break
        }
        if (contadorOponente >= 3) {
            println("¡Ganador final: el Oponente! 🎉🎉🎉")
            break
        }
    }
}
