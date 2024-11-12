import kotlin.random.Random

/*
    * Desarrolla un programa de "Juego de Dados" estilo casino en el que el jugador comienza con 10 "patos" 
    * como fondos iniciales. El jugador puede apostar la cantidad de patos que desee en cada ronda, tratando 
    * de acertar la suma de los dos dados lanzados. El juego continúa hasta que el jugador se quede sin patos,
    * momento en el cual la partida termina automáticamente.
*/
    
fun main() {
    var patos = 10
    println("Bienvenido al Juego de Dados. ¡Tienes 10 patos!")

    while (patos > 0) {
        println("Saldo actual: $patos patos.")
        print("¿Cuántos patos deseas apostar? ")
        val apuesta = readLine()?.toIntOrNull() ?: continue

        if (apuesta > patos || apuesta <= 0) {
            println("Apuesta no válida. Inténtalo de nuevo.")
            continue
        }

        print("Elige una suma entre 2 y 12: ")
        val sumaElegida = readLine()?.toIntOrNull() ?: continue

        if (sumaElegida !in 2..12) {
            println("Suma no válida. Inténtalo de nuevo.")
            continue
        }

        val dado1 = Random.nextInt(1, 7)
        val dado2 = Random.nextInt(1, 7)
        val sumaDados = dado1 + dado2

        println("Lanzaste los dados: Dado 1 = $dado1, Dado 2 = $dado2, Suma = $sumaDados")

        if (sumaDados == sumaElegida) {
            patos += apuesta * 2
            println("¡Felicidades, acertaste! Ganaste ${apuesta * 2} patos.")
        } else {
            patos -= apuesta
            println("No acertaste. Perdiste $apuesta patos.")
        }
    }

    println("Lo siento, te has quedado sin patos. ¡La partida ha terminado!")
}
