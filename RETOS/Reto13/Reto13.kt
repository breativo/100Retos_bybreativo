/*
* Crea un programa que simule un sistema de sorteo para seleccionar ganadores de una lista de participantes almacenada en un archivo de texto plano (formato .txt). 

* El programa debe seguir las siguientes reglas:

    * - El programa debe solicitar al usuario el nombre de un archivo de texto (.txt) que contenga una lista de nombres, donde cada nombre esté en una línea diferente. Si el archivo no existe, el programa debe mostrar un mensaje de error y solicitar nuevamente el archivo.
    * - Una vez cargado el archivo correctamente, el programa debe contar la cantidad total de participantes y mostrar este número al usuario.
    * - El programa debe preguntar cuántos ganadores desea seleccionar el usuario.
    * - El número de ganadores no puede ser mayor que el número de participantes. Si el número de ganadores es mayor, el programa debe mostrar un mensaje de error y solicitar nuevamente el número de ganadores.
    * - El programa debe seleccionar aleatoriamente a los ganadores de la lista, garantizando que no se repitan.
    * - Una vez realizado el sorteo, el programa debe mostrar los nombres de los ganadores.

* Consideraciones adicionales:

    * - El archivo .txt debe tener un formato en el que cada nombre de participante esté en una línea distinta.
    * - El programa debe validar que el archivo de texto existe y contiene al menos un participante antes de continuar.
    * - Si el número de ganadores es válido, se deben seleccionar de manera aleatoria y sin repetición.
    * - Los nombres de los ganadores deben mostrarse en una lista ordenada.
*/
import java.io.File
import java.util.*

fun cargarLista(archivo: String): List<String> {
    return try {
        File(archivo).readLines().map { it.trim() }
    } catch (e: Exception) {
        println("El archivo no existe. Intenta nuevamente.")
        emptyList()
    }
}

fun seleccionarGanadores(nombres: List<String>, numGanadores: Int): List<String> {
    return nombres.shuffled().take(numGanadores)
}

fun main() {
    val scanner = Scanner(System.`in`)
    
    print("Introduce el nombre del archivo con la lista de participantes: ")
    //Importante introducir la url absoluta del fichero con los participantes
    val archivo = scanner.nextLine()

    val nombres = cargarLista(archivo)

    if (nombres.isEmpty()) return

    println("Se han cargado ${nombres.size} participantes.")

    var numGanadores: Int
    while (true) {
        print("¿Cuántos ganadores deseas seleccionar? ")
        numGanadores = scanner.nextInt()
        if (numGanadores > nombres.size) {
            println("El número de ganadores no puede ser mayor al número de participantes.")
        } else {
            break
        }
    }

    val ganadores = seleccionarGanadores(nombres, numGanadores)
    println("\nLos ganadores seleccionados son:")
    ganadores.forEachIndexed { index, ganador -> 
        println("${index + 1}. $ganador")
    }
}
