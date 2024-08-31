/*
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
 */
const readline = require('readline');

// Crear una interfaz de lectura para capturar entrada del usuario
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const contarPalabras = (texto) => {
    // Convertir a minúsculas y eliminar signos de puntuación
    texto = texto.toLowerCase().replace(/[^a-z\s]/g, '');

    // Dividir el texto en palabras
    const palabras = texto.split(/\s+/);

    // Usar un objeto para contar las palabras
    const contadorPalabras = {};

    palabras.forEach(palabra => {
        if (palabra) { // Ignorar cadenas vacías
            contadorPalabras[palabra] = (contadorPalabras[palabra] || 0) + 1;
        }
    });

    return contadorPalabras;
};

// Pedir la entrada del usuario
rl.question('Ingresa el texto: ', (texto) => {
    const conteo = contarPalabras(texto);
    for (const palabra in conteo) {
        console.log(`${palabra}: ${conteo[palabra]}`);
    }
    rl.close(); // Cerrar la interfaz de lectura
});
