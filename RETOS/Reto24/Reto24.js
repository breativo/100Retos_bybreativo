    /*
    * Crea un programa que simule una carrera de camellos en el que el usuario selecciona uno de los siete camellos
    * y los camellos avanzan de acuerdo con tiradas aleatorias. El primero que llegue a la meta (casilla 10) ganará
    * la carrera.
    */
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function carreraDeCamellos() {
    
    let camellos = Array(7).fill(0);
    const meta = 10;
    let carreraTerminada = false;

    console.log("¡Bienvenido a la carrera de camellos!");
    rl.question("Elige tu camello (1 a 7): ", (camelloElegido) => {
        camelloElegido = parseInt(camelloElegido) - 1;  

        
        while (!carreraTerminada) {
            
            for (let i = 0; i < 7; i++) {
                let carreraVisual = "-".repeat(camellos[i]) + (i + 1) + "".repeat(meta - camellos[i]);
                process.stdout.write(carreraVisual + " ");
            }
            console.log();

            
            for (let i = 0; i < 7; i++) {
                if (Math.floor(Math.random() * 7) === i) {  
                    camellos[i]++;
                }
            }

            
            for (let i = 0; i < 7; i++) {
                if (camellos[i] >= meta) {
                    console.log(`¡El camello ${i + 1} ha llegado a la meta!`);
                    if (i === camelloElegido) {
                        console.log("¡Felicidades! Has ganado.");
                    } else {
                        console.log("¡Lo siento! Tu camello no ganó.");
                    }
                    carreraTerminada = true;
                    break;
                }
            }
        }

        rl.close();
    });
}

carreraDeCamellos();
