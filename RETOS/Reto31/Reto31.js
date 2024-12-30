// Solución en Node.js
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const icons = ["🍒", "🔔", "🍋", "💎", "⭐", "🎲", "🌈", "🔥", "🍉", "❤️"];
let coins = 25;
let totalGames = 0;
let wins = 0;
let totalCoinsWon = 0;
let longestLosingStreak = 0;
let currentLosingStreak = 0;
let wildcardWins = 0;

console.log("Bienvenido a la Máquina Tragaperras con Comodín");
console.log(`Comienzas con ${coins} monedas. Buena suerte!\n`);

function playGame() {
    if (coins <= 0) {
        console.log("Te has quedado sin monedas. Fin del juego.");
        printStats();
        rl.close();
        return;
    }

    rl.question("Presiona 'a' para jugar o 'b' para salir: ", (choice) => {
        if (choice.toLowerCase() === 'b') {
            printStats();
            rl.close();
            return;
        } else if (choice.toLowerCase() === 'a') {
            coins--;
            totalGames++;

            const result = [
                icons[Math.floor(Math.random() * icons.length)],
                icons[Math.floor(Math.random() * icons.length)],
                icons[Math.floor(Math.random() * icons.length)]
            ];

            console.log(`Resultado: ${result.join(' ')}`);

            let isWin = false;
            if (result[0] === result[1] && result[1] === result[2]) {
                isWin = true;
            } else if (result.includes("🎲") &&
                       (result[0] === result[1] || result[1] === result[2] || result[0] === result[2])) {
                isWin = true;
                wildcardWins++;
            }

            if (isWin) {
                const coinsWon = coins;
                coins += coinsWon;
                totalCoinsWon += coinsWon;
                wins++;
                currentLosingStreak = 0;
                console.log(`¡Ganaste! Has ganado ${coinsWon} monedas. Tu saldo es de ${coins} monedas.\n`);
            } else {
                currentLosingStreak++;
                longestLosingStreak = Math.max(longestLosingStreak, currentLosingStreak);
                console.log(`No hubo acierto. Te quedan ${coins} monedas.\n`);
            }

            playGame();
        } else {
            console.log("Opción no válida. Intenta nuevamente.");
            playGame();
        }
    });
}

function printStats() {
    console.log("\nJuego terminado. Estas son tus estadísticas:");
    console.log(`Jugadas realizadas: ${totalGames}`);
    console.log(`Monedas ganadas: ${totalCoinsWon}`);
    console.log(`Monedas gastadas: ${totalGames}`);
    console.log(`Aciertos logrados: ${wins}`);
    console.log(`Combinaciones con comodín: ${wildcardWins}`);
    console.log(`Racha más larga sin aciertos: ${longestLosingStreak}`);
}

playGame();
