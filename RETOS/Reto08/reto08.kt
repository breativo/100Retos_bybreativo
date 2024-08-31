/*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */
import java.util.Scanner

fun contarPalabras(texto: String): Map<String, Int> {
    // Convertir a minúsculas y eliminar signos de puntuación
    val textoLimpio = texto.lowercase().replace(Regex("[^a-z\\s]"), "")

    // Dividir el texto en palabras
    val palabras = textoLimpio.split(Regex("\\s+"))

    // Usar un mapa para contar las palabras
    val contadorPalabras = mutableMapOf<String, Int>()

    palabras.forEach { palabra ->
        if (palabra.isNotEmpty()) {
            contadorPalabras[palabra] = contadorPalabras.getOrDefault(palabra, 0) + 1
        }
    }

    return contadorPalabras
}

fun main() {
    val scanner = Scanner(System.`in`)
    println("Ingresa el texto:")
    val texto = scanner.nextLine()

    val conteo = contarPalabras(texto)
    conteo.forEach { (palabra, cantidad) ->
        println("$palabra: $cantidad")
    }
}
