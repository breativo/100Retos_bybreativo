/*
* Crea un programa que simule un sistema de sorteo para seleccionar ganadores de una lista de participantes almacenada en un archivo de texto plano (formato .txt). 

* El programa debe seguir las siguientes reglas:

    * - El programa debe solicitar al usuario el nombre de un archivo de texto (.txt) que contenga una lista de nombres, donde cada nombre esté en una línea diferente. Si el archivo no existe, el programa debe mostrar un mensaje de error y solicitar nuevamente el archivo.
    * - Una vez cargado el archivo correctamente, el programa debe contar la cantidad total de participantes y mostrar este número al usuario.
    * - El programa debe preguntar cuántos ganadores desea seleccionar el usuario.
    * - El número de ganadores no puede ser mayor que el número de participantes. Si el número de ganadores es mayor, el programa debe mostrar un mensaje de error y solicitar nuevamente el número de ganadores.
    * - El programa debe seleccionar aleatoriamente a los ganadores de la lista, garantizando que no se repitan.
    * - Una vez realizado el sorteo, el programa debe mostrar los nombres de los ganadores.

* Consideraciones adicionales:

    * - El archivo .txt debe tener un formato en el que cada nombre de participante esté en una línea distinta.
    * - El programa debe validar que el archivo de texto existe y contiene al menos un participante antes de continuar.
    * - Si el número de ganadores es válido, se deben seleccionar de manera aleatoria y sin repetición.
    * - Los nombres de los ganadores deben mostrarse en una lista ordenada.
*/
const fs = require('fs');
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function cargarLista(archivo) {
    try {
        const data = fs.readFileSync(archivo, 'utf8');
        return data.split('\n').map(nombre => nombre.trim()).filter(nombre => nombre.length > 0);
    } catch (err) {
        console.log("El archivo no existe. Intenta nuevamente.");
        return [];
    }
}

function seleccionarGanadores(nombres, numGanadores) {
    let seleccionados = [];
    while (seleccionados.length < numGanadores) {
        const index = Math.floor(Math.random() * nombres.length);
        if (!seleccionados.includes(nombres[index])) {
            seleccionados.push(nombres[index]);
        }
    }
    return seleccionados;
}

rl.question("Introduce el nombre del archivo con la lista de participantes: ", function(archivo) {
    const nombres = cargarLista(archivo);
    
    if (nombres.length === 0) {
        rl.close();
        return;
    }
    
    console.log(`Se han cargado ${nombres.length} participantes.`);
    
    rl.question("¿Cuántos ganadores deseas seleccionar? ", function(numGanadores) {
        numGanadores = parseInt(numGanadores);
        if (numGanadores > nombres.length) {
            console.log("El número de ganadores no puede ser mayor al número de participantes.");
        } else {
            const ganadores = seleccionarGanadores(nombres, numGanadores);
            console.log("\nLos ganadores seleccionados son:");
            ganadores.forEach((ganador, index) => {
                console.log(`${index + 1}. ${ganador}`);
            });
        }
        rl.close();
    });
});
