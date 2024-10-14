/*
Crea un programa que dibuje una escalera en función del número de escalones proporcionado por el usuario. El programa debe seguir las siguientes reglas:

- Si el número de escalones es positivo, la escalera será ascendente de izquierda a derecha. Cada peldaño estará compuesto por un guion bajo (_) y una barra vertical (|), con un desplazamiento hacia la derecha en cada línea.
- Si el número de escalones es negativo, la escalera será descendente de izquierda a derecha. En este caso, cada peldaño estará compuesto por una barra vertical (|) y un guion bajo (_), con un desplazamiento hacia la derecha en cada línea.
- Si el número de escalones es cero, se dibujarán dos guiones bajos (__) en dos líneas diferentes.
 */
fun dibujarEscalera(n: Int) {
    if (n > 0) {
        // Escalera ascendente
        for (i in 0 until n) {
            println(" ".repeat(n - i - 1) + "_|")
        }
    } else if (n < 0) {
        // Escalera descendente
        for (i in 0 until -n) {
            println(" ".repeat(i) + "|_")
        }
    } else {
        // Caso especial para n == 0
        println("__")
    }
}

fun main() {
    var escalones: Int
    var entradaValida = false

    while (!entradaValida) {
        print("Introduce el número de escalones: ")
        val entrada = readLine()

        try {
            escalones = entrada?.toInt() ?: throw NumberFormatException()
            entradaValida = true // La entrada es válida, salimos del bucle
            dibujarEscalera(escalones)
        } catch (e: NumberFormatException) {
            println("Por favor, introduce un número entero válido.")
        }
    }
}
