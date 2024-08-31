/*
*Escribe un programa que reciba un solo carácter por parte del usuario y muestre por consola (con un print) si dicho carácter es una vocal o una consonante. Si el carácter no es una letra, el programa deberá mostrar un mensaje de error.

* - Si el carácter es una vocal, mostrará: "Es una vocal".
* - Si el carácter es una consonante, mostrará: "Es una consonante".
* - Si el carácter no es una letra (números, símbolos, espacios, etc.), mostrará: "Error: No es una letra".

*El programa debe funcionar tanto para letras mayúsculas como minúsculas.
*/
const readline = require('readline');

// Crear una interfaz de lectura para capturar entrada del usuario
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const clasificarCaracter = (caracter) => {
    // Convertir a minúscula para simplificar la comparación
    const c = caracter.toLowerCase();

    // Verificar si es una letra
    if (/[a-z]/.test(c)) {
        if ('aeiou'.includes(c)) {
            return "Es una vocal.";
        } else {
            return "Es una consonante.";
        }
    } else {
        return "Error: No es una letra.";
    }
};

// Pedir la entrada del usuario
rl.question('Ingresa un solo carácter: ', (input) => {
    if (input.length !== 1) {
        console.log("Error: Se debe ingresar solo un carácter.");
    } else {
        console.log(clasificarCaracter(input));
    }
    rl.close(); // Cerrar la interfaz de lectura
});
