/*
 * Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
 *
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 */
fun invertirCadena(texto: String): String {
    val caracteres = texto.toCharArray()
    val longitud = caracteres.size

    // Invertir el arreglo de caracteres
    for (i in 0 until longitud / 2) {
        val temp = caracteres[i]
        caracteres[i] = caracteres[longitud - 1 - i]
        caracteres[longitud - 1 - i] = temp
    }

    return String(caracteres)
}

fun main() {
    print("Ingresa una cadena de texto: ")
    val texto = readLine() ?: ""
    println("Cadena invertida: ${invertirCadena(texto)}")
}
