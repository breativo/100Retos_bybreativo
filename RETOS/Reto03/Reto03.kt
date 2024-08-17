package Kotlin
/*
*Escribe un programa que imprima los 50 primeros números de la sucesión
*de Fibonacci empezando en 0.
    *- La serie Fibonacci se compone por una sucesión de números en
    * la que el siguiente siempre es la suma de los dos anteriores.
    * 0, 1, 1, 2, 3, 5, 8, 13...
 */
fun main(){

    val numero=50
    var a=0
    var b=1
    println(a)
    println(b)

    for (i in 2 until numero) {
        val next= a+b 
        println(next)
        a=b
        b=next        
    }

}
