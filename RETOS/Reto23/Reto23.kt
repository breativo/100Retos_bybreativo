import kotlin.random.Random

/*
* Crea un programa que simule una carrera de obstáculos para un único atleta, quien debe completar un circuito de 20 tramos. El circuito se genera aleatoriamente y contiene tramos de suelo ("_") y vallas ("|"). El atleta solo puede ingresar las acciones "run" para correr y "jump" para saltar.

* Circuito:

    *- El circuito consta de 20 tramos generados aleatoriamente. Cada tramo puede ser suelo ("_") o valla ("|") con una probabilidad de 50% para cada uno.

* Acciones del Atleta:

    * - El atleta solo puede ingresar "run" o "jump". Si escribe mal una acción o elige incorrectamente, se considera un fallo.

*Tiempo y Penalización:

    * - Cada tramo correcto añade 1 segundo al tiempo total.
    * - Cada fallo (acción incorrecta o error de escritura) añade una penalización de 2 segundos adicionales.
    *- Al finalizar el circuito, el programa muestra el tiempo total y el número de fallos cometidos.
*/

fun generarPista(): String {
    return (1..20).joinToString("") { if (Random.nextBoolean()) "_" else "|" }
}

fun main() {

    print("Ingrese el nombre del atleta: ")
    val nombre = readLine()!!

    
    val circuito = generarPista()
    println("Circuito generado: $circuito")


    var tiempoTotal = 0
    var fallos = 0


    for (i in circuito.indices) {
        val tramo = circuito[i]
        print("Tramo ${i + 1} (${if (tramo == '_') "suelo" else "valla"}): ")
        val accion = readLine()!!.trim().toLowerCase()

        if ((tramo == '_' && accion == "run") || (tramo == '|' && accion == "jump")) {
            tiempoTotal += 1  
        } else {
            tiempoTotal += 3  
            fallos += 1
        }
    }

    println("Tiempo total de $nombre: $tiempoTotal segundos")
    println("Fallos de $nombre: $fallos")
}
