/*
* Desarrollar un programa que seleccione una palabra aleatoria de un archivo de texto (.txt) y oculte el 50% de las letras de la palabra. 
* El usuario deberá adivinar las letras faltantes, teniendo un máximo de 2 errores permitidos. Si introduce una letra incorrecta por tercera vez, perderá el juego.

* Descripción del Ejercicio:

* - El programa leerá un archivo de texto (palabras.txt) que contiene una lista de palabras (una palabra por línea).
* - Seleccionará aleatoriamente una palabra del archivo.
* - Ocultará el 50% de las letras de la palabra seleccionada, mostrando los espacios en blanco como guiones bajos (_).
*/
const fs = require('fs');

function leerPalabras(nombreArchivo) {
    return fs.readFileSync(nombreArchivo, 'utf-8').split('\n').map(linea => linea.trim());
}

function ocultarPalabra(palabra) {
    const longitud = palabra.length;
    const numAOcultar = Math.floor(longitud / 2);
    const indicesOcultos = new Set();

    while (indicesOcultos.size < numAOcultar) {
        indicesOcultos.add(Math.floor(Math.random() * longitud));
    }

    return [...palabra].map((letra, i) => (indicesOcultos.has(i) ? '_' : letra)).join('');
}

function mostrarPalabra(palabra, letrasAdivinadas) {
    return [...palabra].map(letra => (letrasAdivinadas.has(letra) ? letra : '_')).join('');
}

const palabras = leerPalabras('palabras.txt');
const palabra = palabras[Math.floor(Math.random() * palabras.length)];
const letrasErroneas = new Set();
const letrasAdivinadas = new Set();
let errores = 0;

const palabraOculta = ocultarPalabra(palabra);
console.log(`Palabra: ${palabraOculta}`); // Muestra la palabra con 50% visible

const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

function juego() {
    if (errores < 2) {
        readline.question('Introduce una letra: ', (letra) => {
            letra = letra.toLowerCase();

            if (palabra.includes(letra)) {
                letrasAdivinadas.add(letra);
                console.log(`¡Bien! Has acertado la letra: ${letra}`);
            } else {
                if (!letrasErroneas.has(letra)) {
                    letrasErroneas.add(letra);
                    errores++;
                    console.log(`¡Fallaste! Letras incorrectas: ${Array.from(letrasErroneas).join(', ')}`);
                } else {
                    console.log(`Ya has intentado la letra: ${letra}`);
                }
            }

            const palabraMostrada = mostrarPalabra(palabra, letrasAdivinadas);
            console.log(`Palabra: ${palabraMostrada}`);

            if (palabraMostrada === palabra) {
                console.log(`¡Felicidades! Has adivinado la palabra: ${palabra}`);
                readline.close();
            } else {
                juego();
            }
        });
    } else {
        console.log(`Has perdido. La palabra era: ${palabra}`);
        readline.close();
    }
}

juego();
