/*
 * Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
 * El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien gane cada punto del juego.
 *  - Las puntuaciones de un juego son 00, 15, 30, 40, "Deuce" (empate), ventaja.
 * - Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
 *   15 - 00
 *   30 - 00
 *   30 - 15
 *   30 - 30
 *   40 - 30
 *   Deuce
 *   Ventaja P1
 *   Ha ganado el P1
 * - Si quieres, puedes controlar errores en la entrada de datos.   
 * - Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.   
 */

function mostrarPuntuacionTenis(cantidadDePuntos) {
    const puntuacion = ["00", "15", "30", "40"];
    let p1 = 0;
    let p2 = 0;
    let ventaja = "";

    for (let i = 0; i < cantidadDePuntos; i++) {
        const puntoGanado = Math.random() < 0.5 ? "P1" : "P2";

        // Incrementar la puntuación del jugador que ganó el punto
        if (puntoGanado === "P1") p1++;
        else if (puntoGanado === "P2") p2++;

        // Verificar si alguno de los jugadores ha ganado con la condición de 5 puntos
        if(p1=== 5 && p2 <=3){
            console.log("Ha ganado el P1");
            return;
        } 

        if(p2=== 5 && p1 <=3){
            console.log("Ha ganado el P2");
            return;
        } 
        // Determinar el estado del juego
        if (p1 >= 4 || p2 >= 4) {
            if (p1 === p2) {
                // Regresar a "Deuce" si el puntaje está empatado después de 40
                console.log("Deuce");
                ventaja = "";
            } else if (p1 === p2 + 1) {
                // Ventaja para P1
                console.log("Ventaja P1");
                ventaja = "P1";
            } else if (p2 === p1 + 1) {
                // Ventaja para P2
                console.log("Ventaja P2");
                ventaja = "P2";
            } else if (p1 >= p2 + 2 && ventaja === "P1") {
                // Ganador P1
                console.log("Ha ganado el P1");
                return;
            } else if (p2 >= p1 + 2 && ventaja === "P2") {
                // Ganador P2
                console.log("Ha ganado el P2");
                return;
            }
        } else {
            // Mostrar la puntuación habitual antes de llegar a "40"
            console.log(`${puntuacion[Math.min(p1, 3)]} - ${puntuacion[Math.min(p2, 3)]}`);
        }
    }

    // En caso de que haya "Ventaja" y luego se empate de nuevo
    if (p1 >= 3 && p2 >= 3 && ventaja && p1 === p2) {
        console.log("Deuce");
    }
}

// Ejecutar la simulación
mostrarPuntuacionTenis(25); // Puedes ajustar el número de puntos generados
