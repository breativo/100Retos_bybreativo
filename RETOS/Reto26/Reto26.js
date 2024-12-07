/*
 * Crea un programa que simule un sorteo de rifa basado en números aleatorios.
 * El usuario solo debe proporcionar los parámetros necesarios, y el programa 
 * realizará automáticamente el sorteo.
 */

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function generarGanadores(inicio, fin, ganadores) {
    const ganadoresSet = new Set();

    while (ganadoresSet.size < ganadores) {
        const numero = Math.floor(Math.random() * (fin - inicio + 1)) + inicio;
        ganadoresSet.add(numero);
    }

    return Array.from(ganadoresSet);
}

function leerInput(prompt) {
    return new Promise(resolve => {
        rl.question(prompt, answer => resolve(parseInt(answer)));
    });
}

async function main() {
    console.log("¡Bienvenido al sorteo de la suerte!");

    const inicio = await leerInput("Ingresa el número inicial del rango: ");
    const fin = await leerInput("Ingresa el número final del rango: ");

    if (inicio >= fin) {
        console.log("El número inicial debe ser menor que el número final.");
        rl.close();
        return;
    }

    const ganadores = await leerInput("Ingresa la cantidad de ganadores: ");

    if (ganadores > (fin - inicio + 1)) {
        console.log("La cantidad de ganadores no puede ser mayor que el rango de números.");
        rl.close();
        return;
    }

    console.log("\nSimulando el sorteo...");
    const ganadoresArray = generarGanadores(inicio, fin, ganadores);
    console.log("🎉 Los números ganadores son:");
    ganadoresArray.forEach(numero => {
        console.log(`   - ${numero}`);
    });

    console.log("\n¡Gracias por participar en el sorteo de la rifa!");
    rl.close();
}

main();
