/*
    *Reto #1
    *¿ES UN ANAGRAMA?
    *Dificultad: MEDIA

    *Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
* -Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
* -NO hace falta comprobar que ambas palabras existan.
* -Dos palabras exactamente iguales no son anagrama.
 */

function esAnagrama(palabra1, palabra2) {
    // Si las palabras son exactamente iguales, no son anagramas
    if (palabra1.toLowerCase() === palabra2.toLowerCase()) return false;
    
    // Ordenar los caracteres de ambas palabras y compararlas
    const ordenarPalabra = palabra => palabra.toLowerCase().split('').sort().join('');
    
    return ordenarPalabra(palabra1) === ordenarPalabra(palabra2);
}

// Ejemplos de uso
console.log(esAnagrama("amor", "roma")); // true
console.log(esAnagrama("roma", "Roma")); // false 

