/*
 * Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.
 *
 * - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
 */
const readline = require('readline');

// Crear una interfaz de lectura para capturar entrada del usuario
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Función para invertir la cadena
const invertirCadena = (texto) => {
    let caracteres = texto.split('');
    let longitud = caracteres.length;

    // Invertir el arreglo de caracteres
    for (let i = 0; i < longitud / 2; i++) {
        let temp = caracteres[i];
        caracteres[i] = caracteres[longitud - 1 - i];
        caracteres[longitud - 1 - i] = temp;
    }

    return caracteres.join('');
};

// Pedir la entrada del usuario
rl.question('Ingresa una cadena de texto: ', (texto) => {
    console.log('Cadena invertida:', invertirCadena(texto));
    rl.close(); // Cerrar la interfaz de lectura
});
