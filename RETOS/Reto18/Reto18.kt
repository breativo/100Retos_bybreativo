import java.util.Scanner


    /*
     * Crea un programa que sea capaz de transformar texto natural a código Morse y viceversa, detectando automáticamente el tipo de entrada (texto o Morse) y realizando la conversión correspondiente.
     * Especificaciones:

     * - Detección automática: El programa debe identificar si el texto de entrada está en lenguaje natural o en código Morse y seleccionar el modo de conversión adecuado.

     * - Formato de Código Morse:
     *       Usa el alfabeto Morse estándar. 
     *       Para representar letras o símbolos, se debe usar una raya (—), un punto (.), un espacio simple ( ) entre letras y símbolos y dos espacios ( ) entre palabras.
     */
    
val morseToText = mapOf(
    ".-" to "A", "-..." to "B", "-.-." to "C", "-.." to "D", "." to "E",
    "..-." to "F", "--." to "G", "...." to "H", ".." to "I", ".---" to "J",
    "-.-" to "K", ".-.." to "L", "--" to "M", "-." to "N", "---" to "O",
    ".--." to "P", "--.-" to "Q", ".-." to "R", "..." to "S", "-" to "T",
    "..-" to "U", "...-" to "V", ".--" to "W", "-..-" to "X", "-.--" to "Y",
    "--.." to "Z", "-----" to "0", ".----" to "1", "..---" to "2",
    "...--" to "3", "....-" to "4", "....." to "5", "-...." to "6",
    "--..." to "7", "---.." to "8", "----." to "9"
)
val textToMorse = morseToText.entries.associate { (k, v) -> v to k }

fun toMorse(text: String): String {
    return text.uppercase().map { char ->
        if (char == ' ') "  " else textToMorse[char.toString()] ?: ""
    }.joinToString(" ")
}

fun toText(morse: String): String {
    return morse.split("  ").joinToString(" ") { word ->
        word.split(" ").joinToString("") { symbol -> morseToText[symbol] ?: "" }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    println("Introduce el texto o código Morse:")
    val input = scanner.nextLine()

    if (input.matches("[.\\- ]+".toRegex())) {
        println("Morse a Texto: ${toText(input)}")
    } else {
        println("Texto a Morse: ${toMorse(input)}")
    }
}
