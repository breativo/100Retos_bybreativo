/*
 * Crea un programa que simule un juego para encontrar un número oculto. El programa debe seguir las siguientes reglas:

* El número oculto será un número entero aleatorio entre 0 y 100.
* El usuario tendrá 5 vidas al comenzar el juego.
* En cada intento, el usuario debe ingresar un número entre 0 y 100.
* Si el número ingresado no es correcto:
       * - El programa restará 1 vida.
       * - El programa dará una pista, indicando si el número oculto es más alto o más bajo que el número ingresado.
* Si el usuario agota las 5 vidas, el programa mostrará un mensaje de "¡Has perdido!" y revelará el número oculto.
* Si el usuario adivina el número oculto antes de quedarse sin vidas, el programa mostrará un mensaje de "¡Has ganado!".

* Consideraciones adicionales:

* El programa debe validar que el número ingresado por el usuario esté dentro del rango permitido (0 - 100). Si el usuario introduce un número fuera del rango, deberá volver a solicitarlo sin penalizar vidas.
* Cada vez que el usuario pierda una vida, el programa debe mostrar cuántas vidas le quedan.
* Cuando el usuario gane o pierda, el programa deberá terminar indicando el número oculto y la cantidad de intentos utilizados (si ganó).
 */
 
import kotlin.random.Random

fun main() {
    val numeroOculto = Random.nextInt(0, 101)
    var vidas = 5
    var intentos = 0

    println("El número oculto está entre 0 y 100.")
    println("Tienes 5 vidas.")

    while (vidas > 0) {
        println("Introduce tu número: ")
        val intento = readLine()?.toIntOrNull() ?: -1
        intentos++

        if (intento !in 0..100) {
            println("El número debe estar entre 0 y 100.")
            continue
        }

        if (intento == numeroOculto) {
            println("¡Has adivinado el número oculto! ¡Has ganado en $intentos intentos!")
            break
        } else {
            vidas--
            if (intento < numeroOculto) {
                println("El número oculto es más alto.")
            } else {
                println("El número oculto es más bajo.")
            }

            if (vidas > 0) {
                println("Te quedan $vidas vidas.")
            } else {
                println("¡Has perdido! El número oculto era: $numeroOculto")
            }
        }
    }
}
