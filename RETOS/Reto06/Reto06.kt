package Kotlin
/*
 * Crea una única función (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.

 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 */
fun calcularArea(tipo: String, medida1: Double, medida2: Double): Double {
    return when (tipo.lowercase()) {
        "triangulo" -> 0.5 * medida1 * medida2 // medida1 es la base, medida2 es la altura
        "cuadrado" -> medida1 * medida1 // medida1 es el lado
        "rectangulo" -> medida1 * medida2 // medida1 es la base, medida2 es la altura
        else -> throw IllegalArgumentException("Tipo de polígono no soportado")
    }
}

fun main() {
    // Imprimir el cálculo del área para cada tipo de polígono
    println("Área del triángulo: ${calcularArea("triangulo", 5.0, 10.0)}") // base 5, altura 10
    println("Área del cuadrado: ${calcularArea("cuadrado", 4.0, 0.0)}") // lado 4
    println("Área del rectángulo: ${calcularArea("rectangulo", 7.0, 3.0)}") // base 7, altura 3
}
