import java.text.SimpleDateFormat
import java.util.*

/*
    * Crea un programa que calcule y retorne cuántos días hay entre dos fechas dadas como cadenas de texto. La segunda fecha siempre debe ser posterior a la primera, de lo contrario, se solicitará ingresar nuevamente ambas fechas en el formato correcto.

    * Especificaciones:

    *- El programa recibirá dos cadenas de texto en el formato "dd-MM-yyyy", representando las fechas a comparar.
    *- Si la segunda fecha es anterior a la primera, el programa solicitará ambas fechas de nuevo hasta que la segunda sea mayor que la primera.
    *- La función debe calcular la diferencia en días y retornar un valor entero (Int).
    *- Si alguna de las dos cadenas no representa una fecha válida en el formato correcto, el programa debe lanzar una excepción.
     */
    
fun main() {
    val formatoFecha = SimpleDateFormat("dd-MM-yyyy").apply { isLenient = false }
    var fecha1: Date
    var fecha2: Date

    while (true) {
        try {
            print("Ingrese la primera fecha (dd-MM-yyyy): ")
            fecha1 = formatoFecha.parse(readLine()!!)!!

            print("Ingrese la segunda fecha (dd-MM-yyyy): ")
            fecha2 = formatoFecha.parse(readLine()!!)!!

            if (fecha2.after(fecha1)) {
                break
            } else {
                println("La segunda fecha debe ser mayor que la primera. Intente de nuevo.")
            }
        } catch (e: Exception) {
            println("Formato de fecha incorrecto. Intente de nuevo.")
        }
    }

    val diferenciaDias = (fecha2.time - fecha1.time) / (1000 * 60 * 60 * 24)
    println("Diferencia en días: $diferenciaDias")
}
