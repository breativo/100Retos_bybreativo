/*
 * Crear un programa que dibuje un árbol de Navidad en la consola. El árbol tendrá la base con el texto "Feliz Navidad" centrado, y el tronco estará en el centro del árbol, compuesto por tres caracteres "|||" en tres filas.

 * Especificaciones del Árbol de Navidad:

 *   - Tamaño total del árbol:
 *       El árbol debe tener 23 espacios en total, contando con la base y el tronco.

 *   - Base del árbol:
 *       La base debe mostrar el texto "Feliz Navidad".
 *       El texto debe estar centrado con respecto a los asteriscos del árbol.

 *   - Tronco:
 *       El tronco estará ubicado directamente debajo de la base, en el centro, y se representará con tres caracteres "|||" en tres filas.

 *   - Formación del árbol:
 *       La cantidad de asteriscos en cada fila disminuye en 2 con respecto a la fila anterior.
 *       La primera fila tiene 13 asteriscos.
 *       La segunda fila tiene 11 asteriscos.
 *       La tercera fila tiene 9 asteriscos.
 *       La cuarta fila tiene 7 asteriscos.
 *       La quinta fila tiene 5 asteriscos.
 *       La sexta fila tiene 3 asteriscos.
 *       La séptima fila tiene 1 asterisco.
 *       Todas las filas deben estar alineadas en el centro.
 */

function drawChristmasTree() {
    const treeWidth = 23;
    let stars = 1;


    for (let i = 0; i < 7; i++) {
        const row = "*".repeat(stars);
        console.log(row.padStart((treeWidth + row.length) / 2).padEnd(treeWidth));
        stars += 2;
    }


    console.log("Feliz Navidad".padStart((treeWidth + 12) / 2).padEnd(treeWidth));


    const trunk = "|||";
    for (let i = 0; i < 3; i++) {
        console.log(trunk.padStart((treeWidth + trunk.length) / 2).padEnd(treeWidth));
    }
}

drawChristmasTree();
