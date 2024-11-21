    /*
     * Crea un programa que simule una carrera de camellos en el que el usuario selecciona uno de los siete camellos
     * y los camellos avanzan de acuerdo con tiradas aleatorias. El primero que llegue a la meta (casilla 10) ganará
     * la carrera.
     */
import kotlin.random.Random

fun carreraDeCamellos() {
    
    val camellos = IntArray(7) { 0 }
    val meta = 10
    var carreraTerminada = false
    
    println("¡Bienvenido a la carrera de camellos!")
    print("Elige tu camello (1 a 7): ")
    val camelloElegido = readLine()!!.toInt() - 1  
    
    while (!carreraTerminada) {
        
        for (i in 0 until 7) {
            val carreraVisual = "".repeat(camellos[i]) + (i + 1) + "".repeat(meta - camellos[i])
            print("$carreraVisual ")
        }
        println()

        
        for (i in 0 until 7) {
            if (Random.nextInt(7) == i) {  
                camellos[i]++
            }
        }

        
        for (i in 0 until 7) {
            if (camellos[i] >= meta) {
                println("¡El camello ${i + 1} ha llegado a la meta!")
                if (i == camelloElegido) {
                    println("¡Felicidades! Has ganado.")
                } else {
                    println("¡Lo siento! Tu camello no ganó.")
                }
                carreraTerminada = true
                break
            }
        }
    }
}

fun main() {
    carreraDeCamellos()
}
