/*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 */

function isPrimo(numero){
    if(numero<=1) return false;
    for (let i = 2; i <= Math.sqrt(numero); i++) {
        if(numero%i===0) return false;
    }
    return true;
}

console.log("Números primos entre 1 y 100:");
for (let i = 1; i <= 100; i++) {
    if(isPrimo(i)){
        console.log(i)
    }
}