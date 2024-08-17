package Kotlin
/*
    *Reto #1
    *¿ES UN ANAGRAMA?
    *Dificultad: MEDIA

    *Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
* -Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
* -NO hace falta comprobar que ambas palabras existan.
* -Dos palabras exactamente iguales no son anagrama.
 */
fun main(){
    println(esAnagrama("amor", "roma")) // true
    println(esAnagrama("roma", "Roma")) // false
}

fun esAnagrama(palabra1: String, palabra2: String): Boolean {
    // Si las palabras son iguales, no son anagramas
    if (palabra1.equals(palabra2, ignoreCase = true)) return false
    
    // Ordenar los caracteres de ambas palabras y compararlas
    return palabra1.toLowerCase().toList().sorted() == palabra2.toLowerCase().toList().sorted()
}