import kotlin.random.Random

/*
* Desarrolla un programa que simule un juego de cartas en el que participan el usuario contra a maquina. El jugador principal deberá introducir su nombre para jugar contra el sistema. El objetivo es acercarse lo más posible a 21 puntos sin pasarse.

* Reglas del juego:

* - Cada jugador comienza con una mano vacía y va recibiendo cartas una por una.
* - El valor de las cartas numéricas (2-10) es el mismo que el número de la carta.
* - Las figuras (J, Q, K) valen 10 puntos cada una.
* - El As (A) vale 1 punto.
* - Los jugadores pueden elegir si desean recibir más cartas o plantarse en cualquier momento.
* - El juego finaliza cuando todos los jugadores se plantan o cuando un jugador supera los 21 puntos, en cuyo caso queda eliminado.

* Objetivo:

* - El jugador que quede más cerca de 21 puntos sin pasarse es el ganador.
* - Si todos los jugadores se pasan, no hay ganador.
 */
fun main() {
    var playerScore = 0
    var machineScore = 0
    var playerStand = false
    var machineStand = false

    print("Introduce tu nombre: ")
    val name = readLine()!!

    while (!playerStand || !machineStand) {
        if (!playerStand) {
            print("\n¿Quieres sacar una carta? (s/n): ")
            val answer = readLine()!!.lowercase()
            if (answer == "n") {
                playerStand = true
            } else {
                val card = getRandomCard()
                playerScore += card
                println("Has sacado un $card. Total: $playerScore")
                if (playerScore > 21) {
                    println("$name, tu total es $playerScore. Has perdido.")
                    return
                }
            }
        }

        if (!machineStand) {
            if (machineScore < 17) {
                val card = getRandomCard()
                machineScore += card
                println("La máquina ha sacado un $card. Total de la máquina: $machineScore")
                if (machineScore > 21) {
                    println("La máquina ha perdido. ¡Has ganado!")
                    return
                }
            } else {
                machineStand = true
                println("La máquina se planta.")
            }
        }
    }

    determineWinner(name, playerScore, machineScore)
}

fun getRandomCard(): Int {
    return minOf(Random.nextInt(1, 14), 10)
}

fun determineWinner(name: String, playerScore: Int, machineScore: Int) {
    println("\nPuntuación final: $name: $playerScore, Máquina: $machineScore")
    when {
        playerScore > machineScore -> println("\n¡Has ganado, $name!")
        machineScore > playerScore -> println("\nLa máquina ha ganado.")
        else -> println("\nEs un empate.")
    }
}
