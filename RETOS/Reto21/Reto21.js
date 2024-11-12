/*
    * Crea un programa de cuenta atrás que permita al usuario seleccionar el tiempo en segundos, desde 10 segundos hasta 60 segundos en intervalos de 10 (es decir, 10, 20, 30, 40, 50, o 60 segundos).

    * Especificaciones:

    *- El programa debe mostrar un menú de selección de tiempo, ofreciendo las opciones: 10, 20, 30, 40, 50, o 60 segundos.
    *- El usuario seleccionará un valor para iniciar la cuenta atrás.
    *- Una vez que el usuario haya seleccionado el tiempo, el programa iniciará la cuenta atrás en tiempo real, mostrando el tiempo restante cada segundo hasta llegar a cero.
    *- Al finalizar, el programa mostrará un mensaje indicando que la cuenta atrás ha terminado.
     */
    
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const opciones = [10, 20, 30, 40, 50, 60];

function cuentaAtras(tiempo) {
    console.log(`Iniciando cuenta atrás de ${tiempo} segundos...`);
    let intervalo = setInterval(() => {
        console.log(tiempo);
        tiempo--;
        if (tiempo <= 0) {
            clearInterval(intervalo);
            console.log("¡Tiempo terminado!");
            rl.close();
        }
    }, 1000);
}

function solicitarTiempo() {
    rl.question('Seleccione el tiempo de cuenta atrás: 10, 20, 30, 40, 50, o 60 segundos\n', (respuesta) => {
        let tiempo = parseInt(respuesta);
        if (opciones.includes(tiempo)) {
            cuentaAtras(tiempo);
        } else {
            console.log("Opción no válida. Intente de nuevo.");
            solicitarTiempo();
        }
    });
}

solicitarTiempo();
