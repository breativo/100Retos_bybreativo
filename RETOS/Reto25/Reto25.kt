/*
 * Crea un programa que simule un evento deportivo de los Juegos Olímpicos,
 * donde el usuario puede crear un evento, agregar participantes, simular la
 * competencia y generar un informe con el resultado, incluyendo el podio y 
 * la clasificación por países.
 */

import kotlin.random.Random

data class Participante(val nombre: String, val pais: String)

class Evento(private val nombre: String) {
    private val participantes = mutableListOf<Participante>()

    fun agregarParticipante(nombre: String, pais: String) {
        participantes.add(Participante(nombre, pais))
    }

    fun mostrarParticipantes() {
        println("\nParticipantes registrados en '$nombre':")
        if (participantes.isEmpty()) {
            println("No hay participantes registrados.")
        } else {
            participantes.forEach { println("- ${it.nombre} (${it.pais})") }
        }
    }

    fun simularEvento(): List<Participante>? {
        return if (participantes.size < 3) {
            println("Debe haber al menos 3 participantes para simular el evento.")
            null
        } else {
            participantes.shuffled().take(3)
        }
    }

    fun generarInforme(resultados: List<Participante>) {
        println("\nSimulación del evento '$nombre':")
        println("🥇 Oro: ${resultados[0].nombre} (${resultados[0].pais})")
        println("🥈 Plata: ${resultados[1].nombre} (${resultados[1].pais})")
        println("🥉 Bronce: ${resultados[2].nombre} (${resultados[2].pais})")
    }
}

fun main() {
    val rankingPaises = mutableMapOf<String, IntArray>()

    while (true) {
        println("\nOpciones:")
        println("1. Nuevo evento")
        println("2. Salir")
        print("Selecciona una opción: ")
        val opcion = readLine()

        when (opcion) {
            "1" -> {
                print("Ingresa el nombre del evento: ")
                val nombreEvento = readLine() ?: ""
                val evento = Evento(nombreEvento)

                while (true) {
                    print("Ingresa el nombre del participante (o 0 para terminar): ")
                    val nombreParticipante = readLine() ?: ""
                    if (nombreParticipante == "0") {
                        evento.mostrarParticipantes()
                        break
                    }
                    print("Ingresa el país del participante: ")
                    val pais = readLine() ?: ""
                    evento.agregarParticipante(nombreParticipante, pais)
                }

                val resultados = evento.simularEvento()
                if (resultados != null) {
                    evento.generarInforme(resultados)

                    // Actualizar ranking de países
                    for (i in resultados.indices) {
                        val pais = resultados[i].pais
                        if (!rankingPaises.containsKey(pais)) {
                            rankingPaises[pais] = intArrayOf(0, 0, 0)
                        }
                        when (i) {
                            0 -> rankingPaises[pais]!![0]++ // Oro
                            1 -> rankingPaises[pais]!![1]++ // Plata
                            2 -> rankingPaises[pais]!![2]++ // Bronce
                        }
                    }

                    println("\nRanking de países por medallas:")
                    for ((pais, medallas) in rankingPaises) {
                        println("$pais: ${medallas[0]} Oro, ${medallas[1]} Plata, ${medallas[2]} Bronce")
                    }
                }
            }

            "2" -> {
                println("¡Gracias por participar en los Juegos Olímpicos de París 2024!")
                break
            }

            else -> println("Opción no válida, por favor selecciona una opción válida.")
        }
    }
}
