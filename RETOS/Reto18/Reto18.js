
    /*
     * Crea un programa que sea capaz de transformar texto natural a código Morse y viceversa, detectando automáticamente el tipo de entrada (texto o Morse) y realizando la conversión correspondiente.
     * Especificaciones:

     * - Detección automática: El programa debe identificar si el texto de entrada está en lenguaje natural o en código Morse y seleccionar el modo de conversión adecuado.

     * - Formato de Código Morse:
     *           Usa el alfabeto Morse estándar. 
     *           Para representar letras o símbolos, se debe usar una raya (—), un punto (.), un espacio simple ( ) entre letras y símbolos y dos espacios ( ) entre palabras.
     */

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const morseToText = {
    ".-": "A", "-...": "B", "-.-.": "C", "-..": "D", ".": "E", "..-.": "F",
    "--.": "G", "....": "H", "..": "I", ".---": "J", "-.-": "K", ".-..": "L",
    "--": "M", "-.": "N", "---": "O", ".--.": "P", "--.-": "Q", ".-.": "R",
    "...": "S", "-": "T", "..-": "U", "...-": "V", ".--": "W", "-..-": "X",
    "-.--": "Y", "--..": "Z", "-----": "0", ".----": "1", "..---": "2",
    "...--": "3", "....-": "4", ".....": "5", "-....": "6", "--...": "7",
    "---..": "8", "----.": "9"
};
const textToMorse = Object.fromEntries(Object.entries(morseToText).map(([k, v]) => [v, k]));

function toMorse(text) {
    return text.toUpperCase().split("").map(char => 
        char === " " ? " " : textToMorse[char] || "").join(" ");
}

function toText(morse) {
    return morse.split("  ").map(word => 
        word.split(" ").map(symbol => morseToText[symbol] || "").join("")).join(" ");
}

rl.question("Introduce el texto o código Morse: ", (input) => {
    if (/^[.\- ]+$/.test(input)) {
        console.log("Morse a Texto:", toText(input));
    } else {
        console.log("Texto a Morse:", toMorse(input));
    }
    rl.close();
});
