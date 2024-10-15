/*
* Desarrolla un programa que simule un juego de cartas en el que participan el usuario contra a maquina. El jugador principal deberá introducir su nombre para jugar contra el sistema. El objetivo es acercarse lo más posible a 21 puntos sin pasarse.

*Reglas del juego:

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
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const getRandomCard = () => Math.min(Math.floor(Math.random() * 13) + 1, 10);

let playerScore = 0, machineScore = 0;
let playerStand = false, machineStand = false;

rl.question('Introduce tu nombre: ', (name) => {
    const playTurn = () => {
        if (!playerStand) {
            rl.question('\n¿Quieres sacar una carta? (s/n): ', (answer) => {
                if (answer.toLowerCase() === 'n') {
                    playerStand = true;
                    playTurn();
                } else {
                    const card = getRandomCard();
                    playerScore += card;
                    console.log(`Has sacado un ${card}. Total: ${playerScore}`);
                    if (playerScore > 21) {
                        console.log(`${name}, tu total es ${playerScore}. Has perdido.`);
                        rl.close();
                    } else {
                        playTurn();
                    }
                }
            });
        } else if (!machineStand) {
            if (machineScore < 17) {
                const card = getRandomCard();
                machineScore += card;
                console.log(`La máquina ha sacado un ${card}. Total de la máquina: ${machineScore}`);
                if (machineScore > 21) {
                    console.log("La máquina ha perdido. ¡Has ganado!");
                    rl.close();
                } else {
                    playTurn();
                }
            } else {
                machineStand = true;
                console.log("La máquina se planta.");
                determineWinner(name);
            }
        }
    };

    const determineWinner = (name) => {
        console.log(`\nPuntuación final: ${name}: ${playerScore}, Máquina: ${machineScore}`);
        if (playerScore > machineScore) {
            console.log(`\n¡Has ganado, ${name}!`);
        } else if (machineScore > playerScore) {
            console.log("\nLa máquina ha ganado.");
        } else {
            console.log("\nEs un empate.");
        }
        rl.close();
    };

    playTurn();
});
