package Kotlin
/*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 */

fun main(){
println("Números primos entre 1 y 100:")
for (i in 1..100) {
    if(isPrimo(i)){
        println(i)
    }
}
}

fun isPrimo(numero:Int): Boolean{
if(numero<=1)return false
for (i in 2..Math.sqrt(numero.toDouble()).toInt()) {
    if(numero % i == 0) return false
}
return true
}