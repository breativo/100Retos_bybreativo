/*
*Escribe un programa que reciba un solo carácter por parte del usuario y muestre por consola (con un print) si dicho carácter es una vocal o una consonante. Si el carácter no es una letra, el programa deberá mostrar un mensaje de error.

* - Si el carácter es una vocal, mostrará: "Es una vocal".
* - Si el carácter es una consonante, mostrará: "Es una consonante".
* - Si el carácter no es una letra (números, símbolos, espacios, etc.), mostrará: "Error: No es una letra".

*El programa debe funcionar tanto para letras mayúsculas como minúsculas.
*/
fun clasificarCaracter(caracter: Char): String {
    // Convertir a minúscula para simplificar la comparación
    val c = caracter.lowercaseChar()

    // Verificar si es una letra
    return if (c.isLetter()) {
        if (c in "aeiou") {
            "Es una vocal."
        } else {
            "Es una consonante."
        }
    } else {
        "Error: No es una letra."
    }
}

fun main() {
    print("Ingresa un solo carácter: ")
    val input = readLine()

    if (input.isNullOrEmpty() || input.length != 1) {
        println("Error: Se debe ingresar solo un carácter.")
    } else {
        println(clasificarCaracter(input[0]))
    }
}
