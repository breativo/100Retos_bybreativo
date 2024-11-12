/*
* Crea un programa que simule una carrera de obstáculos para un único atleta, quien debe completar un circuito de 20 tramos. El circuito se genera aleatoriamente y contiene tramos de suelo ("_") y vallas ("|"). El atleta solo puede ingresar las acciones "run" para correr y "jump" para saltar.

* Circuito:

    *- El circuito consta de 20 tramos generados aleatoriamente. Cada tramo puede ser suelo ("_") o valla ("|") con una probabilidad de 50% para cada uno.

* Acciones del Atleta:

    * - El atleta solo puede ingresar "run" o "jump". Si escribe mal una acción o elige incorrectamente, se considera un fallo.

*Tiempo y Penalización:

    * - Cada tramo correcto añade 1 segundo al tiempo total.
    * - Cada fallo (acción incorrecta o error de escritura) añade una penalización de 2 segundos adicionales.
    *- Al finalizar el circuito, el programa muestra el tiempo total y el número de fallos cometidos.
*/

const readlineSync = require('readline-sync');


function generarPista() {
    let pista = '';
    for (let i = 0; i < 20; i++) {
        pista += Math.random() < 0.5 ? '_' : '|';
    }
    return pista;
}


const nombre = readlineSync.question('Ingrese el nombre del atleta: ');


const circuito = generarPista();
console.log(`Circuito generado: ${circuito}`);


let tiempoTotal = 0;
let fallos = 0;


for (let i = 0; i < 20; i++) {
    const tramo = circuito[i];
    const accion = readlineSync.question(`Tramo ${i+1} (${tramo === '_' ? 'suelo' : 'valla'}): `).trim().toLowerCase();

    if ((tramo === '_' && accion === 'run') || (tramo === '|' && accion === 'jump')) {
        tiempoTotal += 1;  
    } else {
        tiempoTotal += 3;  
        fallos += 1;
    }
}


console.log(`Tiempo total de ${nombre}: ${tiempoTotal} segundos`);
console.log(`Fallos de ${nombre}: ${fallos}`);
