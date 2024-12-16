const readline = require('readline');


const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function encriptarMensaje(mensaje, clave) {
    let mensajeEncriptado = '';
    clave = clave % 26; 

    for (let i = 0; i < mensaje.length; i++) {
        let caracter = mensaje[i];
        if (/[a-zA-Z]/.test(caracter)) {
            let base = (caracter === caracter.toLowerCase()) ? 'a' : 'A';
            caracter = String.fromCharCode(base.charCodeAt(0) + (caracter.charCodeAt(0) - base.charCodeAt(0) + clave) % 26);
        }
        mensajeEncriptado += caracter;
    }

    return mensajeEncriptado;
}


rl.question('Introduce el mensaje: ', (mensaje) => {
    rl.question('Introduce la clave: ', (claveStr) => {
        let clave = parseInt(claveStr);
        let mensajeEncriptado = encriptarMensaje(mensaje, clave);
        console.log("Mensaje encriptado: " + mensajeEncriptado);
        rl.close();
    });
});
