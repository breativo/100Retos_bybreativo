/*
 *  Crea un programa que simule un juego de bingo en el que los cartones tienen un formato 5x1 (5 columnas y 1 filas).
 *  Los números en los cartones y las extracciones se generan en el rango de 1 a 50. El objetivo es que los jugadores 
 *  compitan hasta que uno logre tachar todos los números de su cartón.
 */

import kotlin.random.Random
import kotlinx.coroutines.*

fun main() = runBlocking {
    println("¡Bienvenido al juego de Bingo!")


    print("Ingrese el número de jugadores: ")
    val numJugadores = readLine()?.toIntOrNull() ?: return@runBlocking

    val jugadores = mutableListOf<String>()
    val cartones = mutableMapOf<String, MutableList<Any>>()

    for (i in 1..numJugadores) {
        print("Ingrese el nombre del jugador $i: ")
        val nombre = readLine() ?: "Jugador $i"
        jugadores.add(nombre)
        cartones[nombre] = generarCarton()
    }


    println("\nCartones generados:")
    jugadores.forEach { jugador ->
        println("$jugador: ${cartones[jugador]?.joinToString(", ")}")
    }

    println("\n¡Comienza el juego!")
    val numerosCantados = mutableSetOf<Int>()
    var hayGanador = false


    while (!hayGanador) {

        var numero: Int
        do {
            numero = Random.nextInt(0, 51) 
        } while (numero in numerosCantados)
        numerosCantados.add(numero)

        println("\nNúmero cantado: $numero")


        for (jugador in jugadores) {
            val carton = cartones[jugador]
            if (carton != null && numero in carton) {
                val index = carton.indexOf(numero)
                carton[index] = "X"
                println("$jugador tiene el número $numero en su cartón.")
            } else {
                println("$jugador no tiene el número $numero.")
            }


            if (esGanador(carton)) {
                println("\n¡$jugador ha hecho Bingo y es el ganador!")
                hayGanador = true
                break
            }
        }

        if (!hayGanador) {

            println("\nEstado de los cartones:")
            jugadores.forEach { jugador ->
                println("$jugador: ${cartones[jugador]?.joinToString(", ")}")
            }
            println("Esperando 10 segundos para el siguiente número...")
            delay(10000L) 
        }
    }

    println("¡Gracias por jugar al Bingo!")
}

fun generarCarton(): MutableList<Any> {
    return mutableListOf(
        Random.nextInt(0, 11),       
        Random.nextInt(11, 21),     
        Random.nextInt(21, 31),     
        Random.nextInt(31, 41),     
        Random.nextInt(41, 51)      
    )
}

fun esGanador(carton: List<Any>?): Boolean {
    return carton?.all { it == "X" } == true
}
