/*
    * Desarrolla un programa de "Juego de Dados" estilo casino en el que el jugador comienza con 10 "patos" 
    * como fondos iniciales. El jugador puede apostar la cantidad de patos que desee en cada ronda, tratando 
    * de acertar la suma de los dos dados lanzados. El juego continúa hasta que el jugador se quede sin patos,
    * momento en el cual la partida termina automáticamente.
*/
    
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let patos = 10;
console.log("Bienvenido al Juego de Dados. ¡Tienes 10 patos!");

function jugar() {
    if (patos <= 0) {
        console.log("Lo siento, te has quedado sin patos. ¡La partida ha terminado!");
        rl.close();
        return;
    }

    console.log(`Saldo actual: ${patos} patos.`);
    rl.question("¿Cuántos patos deseas apostar? ", (apuesta) => {
        apuesta = parseInt(apuesta);
        if (isNaN(apuesta) || apuesta <= 0 || apuesta > patos) {
            console.log("Apuesta no válida. Inténtalo de nuevo.");
            return jugar();
        }

        rl.question("Elige una suma entre 2 y 12: ", (sumaElegida) => {
            sumaElegida = parseInt(sumaElegida);
            if (isNaN(sumaElegida) || sumaElegida < 2 || sumaElegida > 12) {
                console.log("Suma no válida. Inténtalo de nuevo.");
                return jugar();
            }

            const dado1 = Math.floor(Math.random() * 6) + 1;
            const dado2 = Math.floor(Math.random() * 6) + 1;
            const sumaDados = dado1 + dado2;

            console.log(`Lanzaste los dados: Dado 1 = ${dado1}, Dado 2 = ${dado2}, Suma = ${sumaDados}`);

            if (sumaDados === sumaElegida) {
                patos += apuesta * 2;
                console.log(`¡Felicidades, acertaste! Ganaste ${apuesta * 2} patos.`);
            } else {
                patos -= apuesta;
                console.log(`No acertaste. Perdiste ${apuesta} patos.`);
            }
            jugar();
        });
    });
}

jugar();
