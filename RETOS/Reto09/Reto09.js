/*
* Desarrolla un programa que determine quién gana más partidas en el juego "Piedra, Papel o Tijera". El resultado final puede ser "Jugador 1", "Jugador 2" o "Empate". La función debe recibir como entrada una lista de pares, donde cada par representa una jugada realizada por el Jugador 1 y el Jugador 2. Cada jugada se representará mediante las siguientes opciones:

    *"Piedra"
    *"Papel"
    *"Tijera"

*El programa debe comparar las jugadas de cada par, determinar el ganador de cada partida, contabilizar las victorias de cada jugador, y finalmente devolver quién ganó más partidas, o si hubo un empate.

*Ejemplo de Entrada:

*[("Piedra", "Tijera"), ("Tijera", "Piedra"), ("Papel", "Tijera")]

*Pistas:
*Recuerda las reglas básicas del juego: Piedra vence a Tijera, Tijera vence a Papel, y Papel vence a Piedra.
*/
let contadorUsuario = 0;
let contadorOponente = 0;
const numeropartidas = 8;
const partida = ["Piedra", "Papel", "Tijera"];

for (let contador = 0; contador < numeropartidas; contador++) {
    let usuario = partida[Math.floor(Math.random() * partida.length)];
    let oponente = partida[Math.floor(Math.random() * partida.length)];
    console.log("Usuario: " + usuario);
    console.log("Oponente: " + oponente);

    if (usuario === oponente) {
        console.log("¡Es un empate!");
    } else if (
        (usuario === "Piedra" && oponente === "Tijera") ||
        (usuario === "Papel" && oponente === "Piedra") ||
        (usuario === "Tijera" && oponente === "Papel")
    ) {
        console.log("¡Usuario gana!");
        contadorUsuario++;
    } else {
        console.log("¡Oponente gana!");
        contadorOponente++;
    }
}

// Determinar el ganador final después de todas las partidas
if (contadorUsuario > contadorOponente) {
    console.log("Ganador final: Usuario! 🎉🎉🎉");
} else if (contadorOponente > contadorUsuario) {
    console.log("Ganador final: Oponente! 🎉🎉🎉");
} else {
    console.log("¡Empate final!");
}
