/*
 * Crea un programa que cuente el número de vocales en una frase ingresada por el usuario. El programa debe seguir estas reglas:

* - Solicitar al usuario que ingrese una frase. La frase puede contener letras mayúsculas y minúsculas.
* - Preguntar al usuario si quiere contar:
        
       * Todas las vocales (a, e, i, o, u).
       *  Una vocal específica (el usuario debe ingresar cuál vocal desea contar).

* - Contar el número de vocales según la elección del usuario. No debe diferenciar entre mayúsculas y minúsculas.
* - Mostrar el resultado al usuario. Indicar cuántas vocales se encontraron en la frase, según la opción elegida.

* Consideraciones Adicionales:

* - El programa debe manejar frases vacías y mostrar un mensaje adecuado si no se encuentran vocales. 
 */


fun main() {
    println("Introduce una frase: ")
    val frase = readLine()!!

    println("¿Quieres contar todas las vocales o una vocal específica? (todas/vocal): ")
    val tipo = readLine()!!

    var contador = 0

    if (tipo.equals("todas", ignoreCase = true)) {
        for (c in frase) {
            if (c.lowercase() in "aeiou") {
                contador++
            }
        }
        println("El número total de vocales en la frase es: $contador")
    } else if (tipo.equals("vocal", ignoreCase = true)) {
        println("¿Cuál vocal deseas contar? (a/e/i/o/u): ")
        val vocal = readLine()!!.single()
        for (c in frase) {
            if (c.lowercase() == vocal.lowercase()) {
                contador++
            }
        }
        println("El número de '$vocal' en la frase es: $contador")
    } else {
        println("Opción no válida.")
    }
}
