/*
 * Crea un programa que simule un juego para encontrar un número oculto. El programa debe seguir las siguientes reglas:

* El número oculto será un número entero aleatorio entre 0 y 100.
* El usuario tendrá 5 vidas al comenzar el juego.
* En cada intento, el usuario debe ingresar un número entre 0 y 100.
* Si el número ingresado no es correcto:
       * - El programa restará 1 vida.
       * - El programa dará una pista, indicando si el número oculto es más alto o más bajo que el número ingresado.
* Si el usuario agota las 5 vidas, el programa mostrará un mensaje de "¡Has perdido!" y revelará el número oculto.
* Si el usuario adivina el número oculto antes de quedarse sin vidas, el programa mostrará un mensaje de "¡Has ganado!".

* Consideraciones adicionales:

* El programa debe validar que el número ingresado por el usuario esté dentro del rango permitido (0 - 100). Si el usuario introduce un número fuera del rango, deberá volver a solicitarlo sin penalizar vidas.
* Cada vez que el usuario pierda una vida, el programa debe mostrar cuántas vidas le quedan.
* Cuando el usuario gane o pierda, el programa deberá terminar indicando el número oculto y la cantidad de intentos utilizados (si ganó).
 */
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const numeroOculto = Math.floor(Math.random() * 101);
let vidas = 5;
let intentos = 0;

console.log("El número oculto está entre 0 y 100.");
console.log("Tienes 5 vidas.");

function preguntarNumero() {
    if (vidas > 0) {
        rl.question('Introduce tu número: ', (respuesta) => {
            const intento = parseInt(respuesta, 10);
            intentos++;

            if (isNaN(intento) || intento < 0 || intento > 100) {
                console.log("El número debe estar entre 0 y 100.");
                preguntarNumero();
            } else if (intento === numeroOculto) {
                console.log(`¡Has adivinado el número oculto! ¡Has ganado en ${intentos} intentos!`);
                rl.close();
            } else {
                vidas--;
                if (intento < numeroOculto) {
                    console.log("El número oculto es más alto.");
                } else {
                    console.log("El número oculto es más bajo.");
                }

                if (vidas > 0) {
                    console.log(`Te quedan ${vidas} vidas.`);
                    preguntarNumero();
                } else {
                    console.log(`¡Has perdido! El número oculto era: ${numeroOculto}`);
                    rl.close();
                }
            }
        });
    }
}

preguntarNumero();
