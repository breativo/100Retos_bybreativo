/*
 * Crea un programa que genere automáticamente una matriz cuadrada de dimensiones impares (3x3, 5x5, 7x7, etc.) con números enteros que formen una espiral. El número 1 debe colocarse en el centro de la matriz, y los números restantes deben expandirse en espiral hacia afuera en sentido horario.

 * Especificaciones:

 *  - Entrada del Usuario:
 *       Solicitar al usuario un número impar nn que representa el tamaño de la matriz (por ejemplo, 3, 5, 7, etc.).
 *       El programa debe validar que el número ingresado sea impar y mayor o igual a 3.

 *   - Generación de la Matriz:
 *       La matriz generada debe tener n×nn×n elementos.
 *       El número 1 debe ubicarse en el centro de la matriz.
 *       Los números restantes (2,3,4,…2,3,4,…) deben rellenar la matriz en forma de espiral hacia afuera en sentido horario.

 *   - Salida del Programa:
 *       Imprimir la matriz generada en formato legible.

 *       Ejemplo con n=5:

 *      17 16 15 14 13
 *       18  5  4  3 12
 *       19  6  1  2 11
 *       20  7  8  9 10
 *       21 22 23 24 25
 */

fun generateSpiralMatrix(size: Int): Array<IntArray> {
    val matrix = Array(size) { IntArray(size) { 0 } }

    var x = size / 2
    var y = size / 2
    var num = 1
    matrix[x][y] = num 
    num++

    val dx = arrayOf(0, 1, 0, -1)
    val dy = arrayOf(1, 0, -1, 0)

    var steps = 1
    var direction = 0 

    while (num <= size * size) {
        for (i in 0 until steps) {
            x += dx[direction]
            y += dy[direction]

            if (x in 0 until size && y in 0 until size) {
                matrix[x][y] = num
                num++
            }
        }

        direction = (direction + 1) % 4

        if (direction == 0 || direction == 2) {
            steps++
        }
    }

    return matrix
}

fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        for (num in row) {
            print("${num.toString().padStart(3)} ")
        }
        println()
    }
}

fun main() {
    print("Ingresa el tamaño de la matriz (impar): ")
    val size = readLine()!!.toInt()

    if (size % 2 == 0 || size < 3) {
        throw IllegalArgumentException("El tamaño debe ser un número impar mayor o igual a 3.")
    }

    val matrix = generateSpiralMatrix(size)
    printMatrix(matrix)
}
