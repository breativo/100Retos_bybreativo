/*
 *  Crea un programa que simule un juego de bingo en el que los cartones tienen un formato 5x1 (5 columnas y 1 filas).
 *  Los números en los cartones y las extracciones se generan en el rango de 1 a 50. El objetivo es que los jugadores 
 *  compitan hasta que uno logre tachar todos los números de su cartón.
 */

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function generarCarton() {
    const carton = [];
    carton.push(Math.floor(Math.random() * 11));        // 0-10
    carton.push(Math.floor(Math.random() * 10) + 11);  // 11-20
    carton.push(Math.floor(Math.random() * 10) + 21);  // 21-30
    carton.push(Math.floor(Math.random() * 10) + 31);  // 31-40
    carton.push(Math.floor(Math.random() * 10) + 41);  // 41-50
    return carton;
}

function esGanador(carton) {
    return carton.every(num => num === 'X');
}

async function iniciarBingo() {
    console.log("¡Bienvenido al juego de Bingo!");
    const jugadores = [];
    const cartones = new Map();

    const numJugadores = await new Promise(resolve => {
        rl.question("Ingrese el número de jugadores: ", num => {
            resolve(parseInt(num));
        });
    });

    for (let i = 0; i < numJugadores; i++) {
        const nombre = await new Promise(resolve => {
            rl.question(`Ingrese el nombre del jugador ${i + 1}: `, nombre => {
                resolve(nombre);
            });
        });
        jugadores.push(nombre);
        cartones.set(nombre, generarCarton());
    }

    console.log("\nCartones generados:");
    jugadores.forEach(jugador => {
        console.log(`${jugador}: [${cartones.get(jugador).join(", ")}]`);
    });

    console.log("\n¡Comienza el juego!");
    const numerosCantados = new Set();
    let hayGanador = false;

    while (!hayGanador) {
        let numero;
        do {
            numero = Math.floor(Math.random() * 51); /
        } while (numerosCantados.has(numero));
        numerosCantados.add(numero);

        console.log(`\nNúmero cantado: ${numero}`);
        jugadores.forEach(jugador => {
            const carton = cartones.get(jugador);
            let tieneNumero = false;

            for (let i = 0; i < carton.length; i++) {
                if (carton[i] === numero) {
                    carton[i] = 'X';
                    console.log(`${jugador} tiene el número ${numero}.`);
                    tieneNumero = true;
                }
            }

            if (!tieneNumero) {
                console.log(`${jugador} no tiene el número ${numero}.`);
            }

            if (esGanador(carton)) {
                console.log(`\n¡${jugador} ha hecho Bingo y es el ganador!`);
                hayGanador = true;
            }
        });

        if (!hayGanador) {
            console.log("\nEstado de los cartones:");
            jugadores.forEach(jugador => {
                console.log(`${jugador}: [${cartones.get(jugador).join(", ")}]`);
            });
            console.log("Esperando 10 segundos para el siguiente número...");
            await new Promise(resolve => setTimeout(resolve, 10000));
        }
    }

    console.log("¡Gracias por jugar al Bingo!");
    rl.close();
}

iniciarBingo();
