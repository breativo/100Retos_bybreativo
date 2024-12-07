/*
 * Crea un programa que simule un sorteo de rifa basado en números aleatorios.
 * El usuario solo debe proporcionar los parámetros necesarios, y el programa 
 * realizará automáticamente el sorteo.
 */

import kotlin.random.Random

fun main() {
    println("¡Bienvenido al sorteo de la suerte!")

    print("Ingresa el número inicial del rango: ")
    val inicio = readLine()!!.toInt()

    print("Ingresa el número final del rango: ")
    val fin = readLine()!!.toInt()

    if (inicio >= fin) {
        println("El número inicial debe ser menor que el número final.")
        return
    }

    print("Ingresa la cantidad de ganadores: ")
    val ganadores = readLine()!!.toInt()

    if (ganadores > (fin - inicio + 1)) {
        println("La cantidad de ganadores no puede ser mayor que el rango de números.")
        return
    }


    val ganadoresSet = mutableSetOf<Int>()

    while (ganadoresSet.size < ganadores) {
        val numero = Random.nextInt(inicio, fin + 1)
        ganadoresSet.add(numero)
    }

    println("\nSimulando el sorteo...")
    println("🎉 Los números ganadores son:")
    ganadoresSet.forEach { println("   - $it") }

    println("\n¡Gracias por participar en el sorteo de la rifa!")
}
