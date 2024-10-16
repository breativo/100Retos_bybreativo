import java.io.File
import kotlin.random.Random

/*
* Desarrollar un programa que seleccione una palabra aleatoria de un archivo de texto (.txt) y oculte el 50% de las letras de la palabra. 
* El usuario deberá adivinar las letras faltantes, teniendo un máximo de 2 errores permitidos. Si introduce una letra incorrecta por tercera vez, perderá el juego.

* Descripción del Ejercicio:

* - El programa leerá un archivo de texto (palabras.txt) que contiene una lista de palabras (una palabra por línea).
* - Seleccionará aleatoriamente una palabra del archivo.
* - Ocultará el 50% de las letras de la palabra seleccionada, mostrando los espacios en blanco como guiones bajos (_).
*/

fun main() {
    val palabras = leerPalabras("palabras.txt")
    val palabra = palabras.random()
    val letrasErroneas = mutableSetOf<Char>()
    val letrasAdivinadas = mutableSetOf<Char>()
    var errores = 0

    val palabraOculta = ocultarPalabra(palabra)
    println("Palabra: $palabraOculta") // Muestra la palabra con 50% visible

    while (errores < 2) {
        print("Introduce una letra: ")
        val letra = readLine()!!.lowercase()[0]

        if (palabra.contains(letra)) {
            letrasAdivinadas.add(letra)
            println("¡Bien! Has acertado la letra: $letra")
        } else {
            if (!letrasErroneas.contains(letra)) {
                letrasErroneas.add(letra)
                errores++
                println("¡Fallaste! Letras incorrectas: ${letrasErroneas.joinToString()}")
            } else {
                println("Ya has intentado la letra: $letra")
            }
        }

        val palabraMostrada = mostrarPalabra(palabra, letrasAdivinadas)
        println("Palabra: $palabraMostrada")

        if (palabraMostrada == palabra) {
            println("¡Felicidades! Has adivinado la palabra: $palabra")
            return
        }
    }

    println("Has perdido. La palabra era: $palabra")
}

fun leerPalabras(nombreArchivo: String): List<String> {
    return File(nombreArchivo).readLines().map { it.trim() }
}

fun ocultarPalabra(palabra: String): String {
    val longitud = palabra.length
    val numAOcultar = longitud / 2
    val indicesOcultos = mutableSetOf<Int>()

    while (indicesOcultos.size < numAOcultar) {
        indicesOcultos.add(Random.nextInt(longitud))
    }

    return palabra.mapIndexed { index, letra -> if (indicesOcultos.contains(index)) '_' else letra }.joinToString("")
}

fun mostrarPalabra(palabra: String, letrasAdivinadas: Set<Char>): String {
    return palabra.map { letra -> if (letrasAdivinadas.contains(letra)) letra else '_' }.joinToString("")
}
