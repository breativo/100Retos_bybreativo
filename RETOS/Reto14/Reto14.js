/*
 * Crea un programa que cuente el número de vocales en una frase ingresada por el usuario. El programa debe seguir estas reglas:

* - Solicitar al usuario que ingrese una frase. La frase puede contener letras mayúsculas y minúsculas.
* - Preguntar al usuario si quiere contar:
        
       * Todas las vocales (a, e, i, o, u).
       *  Una vocal específica (el usuario debe ingresar cuál vocal desea contar).

* - Contar el número de vocales según la elección del usuario. No debe diferenciar entre mayúsculas y minúsculas.
* - Mostrar el resultado al usuario. Indicar cuántas vocales se encontraron en la frase, según la opción elegida.

* Consideraciones Adicionales:

* - El programa debe manejar frases vacías y mostrar un mensaje adecuado si no se encuentran vocales. 
 */

const { close } = require('fs');

const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

readline.question('Introduce una frase: ', (frase) => {
    readline.question('¿Quieres contar todas las vocales o una vocal específica? (todas/vocal): ', (tipo) => {
        let contador = 0;

        if (tipo.toLowerCase() === 'todas') {
            for (const c of frase) {
                if ('aeiouAEIOU'.includes(c)) {
                    contador++;
                    readline.close();
                }
            }
            console.log(`El número total de vocales en la frase es: ${contador}`);
        } else if (tipo.toLowerCase() === 'vocal') {
            readline.question('¿Cuál vocal deseas contar? (a/e/i/o/u): ', (vocal) => {
                for (const c of frase) {
                    if (c.toLowerCase() === vocal.toLowerCase()) {
                        contador++;
                    }
                }
                console.log(`El número de '${vocal}' en la frase es: ${contador}`);
                readline.close();
                
            });
        } else {
            console.log('Opción no válida.');
            readline.close();
        }
    });

});
