/*
 * Crea un programa que genere automáticamente una matriz cuadrada de dimensiones impares (3x3, 5x5, 7x7, etc.) con números enteros que formen una espiral. El número 1 debe colocarse en el centro de la matriz, y los números restantes deben expandirse en espiral hacia afuera en sentido horario.

 * Especificaciones:

 *  - Entrada del Usuario:
 *       Solicitar al usuario un número impar nn que representa el tamaño de la matriz (por ejemplo, 3, 5, 7, etc.).
 *       El programa debe validar que el número ingresado sea impar y mayor o igual a 3.

 *   - Generación de la Matriz:
 *       La matriz generada debe tener n×nn×n elementos.
 *       El número 1 debe ubicarse en el centro de la matriz.
 *       Los números restantes (2,3,4,…2,3,4,…) deben rellenar la matriz en forma de espiral hacia afuera en sentido horario.

 *   - Salida del Programa:
 *       Imprimir la matriz generada en formato legible.

 *       Ejemplo con n=5:

 *      17 16 15 14 13
 *       18  5  4  3 12
 *       19  6  1  2 11
 *       20  7  8  9 10
 *       21 22 23 24 25
 */

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function generateSpiralMatrix(size) {
    let matrix = Array.from({ length: size }, () => Array(size).fill(0));

    let x = Math.floor(size / 2), y = Math.floor(size / 2);
    let num = 1;
    matrix[x][y] = num++; 

    const dx = [0, 1, 0, -1];
    const dy = [1, 0, -1, 0];

    let steps = 1;
    let direction = 0; 

    while (num <= size * size) {
        for (let i = 0; i < steps; i++) {
            x += dx[direction];
            y += dy[direction];

            if (x >= 0 && x < size && y >= 0 && y < size) {
                matrix[x][y] = num++;
            }
        }

        direction = (direction + 1) % 4;

        if (direction === 0 || direction === 2) {
            steps++;
        }
    }

    return matrix;
}

function printMatrix(matrix) {
    matrix.forEach(row => {
        console.log(row.map(num => num.toString().padStart(3, ' ')).join(' '));
    });
}

rl.question("Ingresa el tamaño de la matriz (impar): ", (input) => {
    const size = parseInt(input);
    if (size % 2 === 0 || size < 3) {
        console.log("El tamaño debe ser un número impar mayor o igual a 3.");
        rl.close();
        return;
    }

    const matrix = generateSpiralMatrix(size);
    printMatrix(matrix);

    rl.close(); 
});
