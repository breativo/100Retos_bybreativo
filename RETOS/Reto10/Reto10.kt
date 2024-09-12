/*
    * Crea un programa que simule el comportamiento del sombrero seleccionador del universo mágico de Harry Potter.

    *- De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
    *- Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
    *- En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que coloque al alumno en una de las 4 casas de Hogwarts (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
    *- Ten en cuenta los rasgos de cada casa para hacer las preguntas y crear el algoritmo seleccionador.

    *Por ejemplo, en Slytherin se premia la ambición y la astucia.
 */
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    var gryffindor = 0
    var slytherin = 0
    var hufflepuff = 0
    var ravenclaw = 0

    // Pregunta 1
    println("Pregunta 1: ¿Qué valoras más en un proyecto?")
    println("1) Coraje")
    println("2) Ambición")
    println("3) Lealtad")
    println("4) Intelecto")
    val respuesta1 = scanner.nextLine()

    when (respuesta1) {
        "1" -> gryffindor++
        "2" -> slytherin++
        "3" -> hufflepuff++
        "4" -> ravenclaw++
    }

    // Pregunta 2
    println("Pregunta 2: ¿Qué prefieres?")
    println("1) Liderar")
    println("2) Manipular las reglas a tu favor")
    println("3) Ayudar a otros")
    println("4) Buscar el conocimiento")
    val respuesta2 = scanner.nextLine()

    when (respuesta2) {
        "1" -> gryffindor++
        "2" -> slytherin++
        "3" -> hufflepuff++
        "4" -> ravenclaw++
    }

    // Pregunta 3
    println("Pregunta 3: ¿Cómo afrontas un problema?")
    println("1) Con valor, enfrentándolo directamente")
    println("2) Con astucia, buscando soluciones alternativas")
    println("3) Con paciencia, trabajando duro hasta resolverlo")
    println("4) Con análisis profundo, buscando aprender más sobre el problema")
    val respuesta3 = scanner.nextLine()

    when (respuesta3) {
        "1" -> gryffindor++
        "2" -> slytherin++
        "3" -> hufflepuff++
        "4" -> ravenclaw++
    }

    // Pregunta 4
    println("Pregunta 4: ¿Cuál es tu entorno de trabajo ideal?")
    println("1) Un equipo unido y valiente")
    println("2) Un equipo competitivo y ambicioso")
    println("3) Un equipo colaborador y trabajador")
    println("4) Un equipo intelectual y creativo")
    val respuesta4 = scanner.nextLine()

    when (respuesta4) {
        "1" -> gryffindor++
        "2" -> slytherin++
        "3" -> hufflepuff++
        "4" -> ravenclaw++
    }

    // Pregunta 5
    println("Pregunta 5: ¿Qué te motiva más en un proyecto?")
    println("1) El desafío y el coraje para enfrentarlo")
    println("2) El poder y el éxito que puedes obtener")
    println("3) El compromiso y la dedicación al equipo")
    println("4) El conocimiento y la oportunidad de aprender algo nuevo")
    val respuesta5 = scanner.nextLine()

    when (respuesta5) {
        "1" -> gryffindor++
        "2" -> slytherin++
        "3" -> hufflepuff++
        "4" -> ravenclaw++
    }

    // Determinar casa
    when {
        gryffindor >= slytherin && gryffindor >= hufflepuff && gryffindor >= ravenclaw -> println("¡Has sido asignado a Gryffindor!")
        slytherin >= gryffindor && slytherin >= hufflepuff && slytherin >= ravenclaw -> println("¡Has sido asignado a Slytherin!")
        hufflepuff >= gryffindor && hufflepuff >= slytherin && hufflepuff >= ravenclaw -> println("¡Has sido asignado a Hufflepuff!")
        else -> println("¡Has sido asignado a Ravenclaw!")
    }
}
