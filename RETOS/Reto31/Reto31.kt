// Solución en Kotlin
import kotlin.random.Random

fun main() {
    val icons = listOf("🍒", "🔔", "🍋", "💎", "⭐", "🎲", "🌈", "🔥", "🍉", "❤️")
    var coins = 25
    var totalGames = 0
    var wins = 0
    var totalCoinsWon = 0
    var longestLosingStreak = 0
    var currentLosingStreak = 0
    var wildcardWins = 0

    println("Bienvenido a la Máquina Tragaperras con Comodín")
    println("Comienzas con $coins monedas. ¡Buena suerte!\n")

    while (coins > 0) {
        println("Presiona 'a' para jugar o 'b' para salir.")
        when (readln().lowercase()) {
            "b" -> {
                printStats(totalGames, totalCoinsWon, wins, wildcardWins, longestLosingStreak)
                return
            }
            "a" -> {
                coins--
                totalGames++

                val result = List(3) { icons.random() }
                println("Resultado: ${result.joinToString(" ")}")

                val isWin = when {
                    result[0] == result[1] && result[1] == result[2] -> true
                    result.contains("🎲") && (result[0] == result[1] || result[1] == result[2] || result[0] == result[2]) -> {
                        wildcardWins++
                        true
                    }
                    else -> false
                }

                if (isWin) {
                    val coinsWon = coins
                    coins += coinsWon
                    totalCoinsWon += coinsWon
                    wins++
                    currentLosingStreak = 0
                    println("¡Ganaste! Has ganado $coinsWon monedas. Tu saldo es de $coins monedas.\n")
                } else {
                    currentLosingStreak++
                    longestLosingStreak = maxOf(longestLosingStreak, currentLosingStreak)
                    println("No hubo acierto. Te quedan $coins monedas.\n")
                }
            }
            else -> println("Opción no válida. Intenta nuevamente.")
        }
    }

    println("Te has quedado sin monedas. Fin del juego.")
    printStats(totalGames, totalCoinsWon, wins, wildcardWins, longestLosingStreak)
}

fun printStats(
    totalGames: Int,
    totalCoinsWon: Int,
    wins: Int,
    wildcardWins: Int,
    longestLosingStreak: Int
) {
    println("\nJuego terminado. Estas son tus estadísticas:")
    println("Jugadas realizadas: $totalGames")
    println("Monedas ganadas: $totalCoinsWon")
    println("Monedas gastadas: $totalGames")
    println("Aciertos logrados: $wins")
    println("Combinaciones con comodín: $wildcardWins")
    println("Racha más larga sin aciertos: $longestLosingStreak")
}
