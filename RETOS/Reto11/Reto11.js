/*
 * Crea un programa que simule la generación de contraseñas seguras.

*El programa debe interactuar con el usuario para definir la longitud de la contraseña, permitiendo seleccionar una longitud entre 8 y 12 caracteres.

*La contraseña generada debe cumplir con los siguientes requisitos mínimos:
        * Debe contener al menos una letra mayúscula.
        * Debe contener al menos una letra minúscula.
        * Debe contener al menos un número.
        * Debe contener al menos un carácter especial (por ejemplo, @, #, !, etc.).

*Además, el programa deberá generar contraseñas aleatorias que respeten los criterios mencionados.

*El programa presentará la contraseña generada al usuario una vez que se haya completado el proceso.

*Consideraciones adicionales:
    * El programa debe validar que la longitud de la contraseña ingresada por el usuario esté dentro del rango permitido.
    * Si el usuario introduce una longitud no válida, deberá solicitarla nuevamente.
 */
const readline = require('readline');

function generatePassword(length) {
    const upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const lower = "abcdefghijklmnopqrstuvwxyz";
    const digits = "0123456789";
    const special = "@#&!";
    const allChars = upper + lower + digits + special;

    let password = '';
    
    password += upper[Math.floor(Math.random() * upper.length)];
    password += lower[Math.floor(Math.random() * lower.length)];
    password += digits[Math.floor(Math.random() * digits.length)];
    password += special[Math.floor(Math.random() * special.length)];

    for (let i = 4; i < length; i++) {
        password += allChars[Math.floor(Math.random() * allChars.length)];
    }

    return password;
}

function promptUserForLength() {
    return new Promise((resolve) => {
        const rl = readline.createInterface({
            input: process.stdin,
            output: process.stdout
        });

        function askLength() {
            rl.question("Introduce la longitud deseada de la contraseña (entre 8 y 12 caracteres): ", (answer) => {
                const length = parseInt(answer, 10);
                if (length >= 8 && length <= 12) {
                    rl.close();
                    resolve(length);
                } else {
                    console.log("Por favor, introduce un valor válido entre 8 y 12.");
                    askLength();
                }
            });
        }

        askLength();
    });
}

(async function() {
    const length = await promptUserForLength();
    console.log("Tu contraseña segura es: " + generatePassword(length));
})();
