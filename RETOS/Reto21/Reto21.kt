import kotlinx.coroutines.*

/*
    * Crea un programa de cuenta atrás que permita al usuario seleccionar el tiempo en segundos, desde 10 segundos hasta 60 segundos en intervalos de 10 (es decir, 10, 20, 30, 40, 50, o 60 segundos).

    * Especificaciones:

    *- El programa debe mostrar un menú de selección de tiempo, ofreciendo las opciones: 10, 20, 30, 40, 50, o 60 segundos.
    *- El usuario seleccionará un valor para iniciar la cuenta atrás.
    *- Una vez que el usuario haya seleccionado el tiempo, el programa iniciará la cuenta atrás en tiempo real, mostrando el tiempo restante cada segundo hasta llegar a cero.
    *- Al finalizar, el programa mostrará un mensaje indicando que la cuenta atrás ha terminado.
     */
    
fun main() = runBlocking {
    val opciones = listOf(10, 20, 30, 40, 50, 60)
    var tiempoSeleccionado: Int

    while (true) {
        print("Seleccione el tiempo de cuenta atrás: 10, 20, 30, 40, 50, o 60 segundos\n")
        tiempoSeleccionado = readLine()?.toIntOrNull() ?: continue
        if (tiempoSeleccionado in opciones) break
        println("Opción no válida. Intente de nuevo.")
    }

    println("Iniciando cuenta atrás de $tiempoSeleccionado segundos...")
    for (i in tiempoSeleccionado downTo 1) {
        println(i)
        delay(1000L)
    }
    println("¡Tiempo terminado!")
}
