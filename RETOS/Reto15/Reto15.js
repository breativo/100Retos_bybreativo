/*
Crea un programa que dibuje una escalera en función del número de escalones proporcionado por el usuario. El programa debe seguir las siguientes reglas:

- Si el número de escalones es positivo, la escalera será ascendente de izquierda a derecha. Cada peldaño estará compuesto por un guion bajo (_) y una barra vertical (|), con un desplazamiento hacia la derecha en cada línea.
- Si el número de escalones es negativo, la escalera será descendente de izquierda a derecha. En este caso, cada peldaño estará compuesto por una barra vertical (|) y un guion bajo (_), con un desplazamiento hacia la derecha en cada línea.
- Si el número de escalones es cero, se dibujarán dos guiones bajos (__) en dos líneas diferentes.
*/

const readline = require('readline');

// Crear interfaz para entrada/salida
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Función para dibujar la escalera
function dibujarEscalera(n) {
    if (n > 0) {
        // Escalera ascendente
        for (let i = 0; i < n; i++) {
            console.log(' '.repeat(n - i - 1) + '_|');
        }
    } else if (n < 0) {
        // Escalera descendente
        for (let i = 0; i < Math.abs(n); i++) {
            console.log(' '.repeat(i) + '|_');
        }
    } else {
        // Caso especial para n == 0
        console.log('__');
        console.log('__');
    }
}

// Preguntar al usuario el número de escalones
rl.question('Introduce el número de escalones: ', (input) => {
    const escalones = parseInt(input);
    if (!isNaN(escalones)) {
        dibujarEscalera(escalones);
    } else {
        console.log('Por favor, introduce un número válido.');
    }
    rl.close();
});
