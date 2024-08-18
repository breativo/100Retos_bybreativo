package Kotlin
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
import kotlin.random.Random

fun main() {
    mostrarPuntuacionTenis(20) // Puedes ajustar el número de puntos generados
}

fun mostrarPuntuacionTenis(cantidadDePuntos: Int) {
    val puntuacion = arrayOf("00", "15", "30", "40")
    var p1 = 0
    var p2 = 0
    var enVentaja = ""

    for (i in 1..cantidadDePuntos) {
        val puntoGanado = if (Random.nextBoolean()) "P1" else "P2"

        // Incrementar la puntuación del jugador que ganó el punto
        if (puntoGanado == "P1") p1++
        else if (puntoGanado == "P2") p2++

         // Verificar si alguno de los jugadores ha ganado con la condición de 5 puntos
        if (p1 == 5 && p2 <= 3) {
            println("Ha ganado el P1")
            return
        }
        if (p2 == 5 && p1 <= 3) {
            println("Ha ganado el P2")
            return
        }
        // Determinar el estado del juego
        when {
            p1 >= 4 && p1 >= p2 + 2 -> {
                println("Ha ganado el P1")
                return
            }
            p2 >= 4 && p2 >= p1 + 2 -> {
                println("Ha ganado el P2")
                return
            }
            p1 >= 3 && p2 >= 3 -> {
                if (p1 == p2) {
                    println("Deuce")
                } else if (p1 == p2 + 1) {
                    println("Ventaja P1")
                    enVentaja = "P1"
                } else if (p2 == p1 + 1) {
                    println("Ventaja P2")
                    enVentaja = "P2"
                }
            }
            else -> {
                println("${puntuacion[minOf(p1, 3)]} - ${puntuacion[minOf(p2, 3)]}")
            }
        }

        // Si estaba en ventaja y el jugador con ventaja gana el punto
        if (enVentaja == "P1" && p1 >= 4 && p1 >= p2 + 2) {
            println("Ha ganado el P1")
            return
        }
        if (enVentaja == "P2" && p2 >= 4 && p2 >= p1 + 2) {
            println("Ha ganado el P2")
            return
        }
    }

    // En caso de que haya "Ventaja" y luego se empate de nuevo
    if (p1 >= 3 && p2 >= 3 && enVentaja.isNotEmpty() && p1 == p2) {
        println("Deuce")
    }
}
