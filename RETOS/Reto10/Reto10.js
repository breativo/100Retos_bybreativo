/*
    * Crea un programa que simule el comportamiento del sombrero seleccionador del universo mágico de Harry Potter.

    *- De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
    *- Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
    *- En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que coloque al alumno en una de las 4 casas de Hogwarts (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
    *- Ten en cuenta los rasgos de cada casa para hacer las preguntas y crear el algoritmo seleccionador.

    *Por ejemplo, en Slytherin se premia la ambición y la astucia.
*/

const readline = require('readline');

// Crear una interfaz de lectura para capturar entrada del usuario
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let gryffindor = 0, slytherin = 0, hufflepuff = 0, ravenclaw = 0;

const hacerPregunta = (pregunta) => {
    return new Promise((resolve) => {
        rl.question(pregunta, (respuesta) => {
            resolve(respuesta.trim());
        });
    });
};

const iniciar = async () => {
    // Pregunta 1
    let respuesta1 = await hacerPregunta("Pregunta 1: ¿Qué valoras más en un proyecto?\n1) Coraje\n2) Ambición\n3) Lealtad\n4) Intelecto\n");
    if (respuesta1 === "1") gryffindor++;
    else if (respuesta1 === "2") slytherin++;
    else if (respuesta1 === "3") hufflepuff++;
    else if (respuesta1 === "4") ravenclaw++;

    // Pregunta 2
    let respuesta2 = await hacerPregunta("Pregunta 2: ¿Qué prefieres?\n1) Liderar\n2) Manipular las reglas a tu favor\n3) Ayudar a otros\n4) Buscar el conocimiento\n");
    if (respuesta2 === "1") gryffindor++;
    else if (respuesta2 === "2") slytherin++;
    else if (respuesta2 === "3") hufflepuff++;
    else if (respuesta2 === "4") ravenclaw++;

    // Pregunta 3
    let respuesta3 = await hacerPregunta("Pregunta 3: ¿Cómo afrontas un problema?\n1) Con valor, enfrentándolo directamente\n2) Con astucia, buscando soluciones alternativas\n3) Con paciencia, trabajando duro hasta resolverlo\n4) Con análisis profundo, buscando aprender más sobre el problema\n");
    if (respuesta3 === "1") gryffindor++;
    else if (respuesta3 === "2") slytherin++;
    else if (respuesta3 === "3") hufflepuff++;
    else if (respuesta3 === "4") ravenclaw++;

    // Pregunta 4
    let respuesta4 = await hacerPregunta("Pregunta 4: ¿Cuál es tu entorno de trabajo ideal?\n1) Un equipo unido y valiente\n2) Un equipo competitivo y ambicioso\n3) Un equipo colaborador y trabajador\n4) Un equipo intelectual y creativo\n");
    if (respuesta4 === "1") gryffindor++;
    else if (respuesta4 === "2") slytherin++;
    else if (respuesta4 === "3") hufflepuff++;
    else if (respuesta4 === "4") ravenclaw++;

    // Pregunta 5
    let respuesta5 = await hacerPregunta("Pregunta 5: ¿Qué te motiva más en un proyecto?\n1) El desafío y el coraje para enfrentarlo\n2) El poder y el éxito que puedes obtener\n3) El compromiso y la dedicación al equipo\n4) El conocimiento y la oportunidad de aprender algo nuevo\n");
    if (respuesta5 === "1") gryffindor++;
    else if (respuesta5 === "2") slytherin++;
    else if (respuesta5 === "3") hufflepuff++;
    else if (respuesta5 === "4") ravenclaw++;

    // Determinar casa
    if (gryffindor >= slytherin && gryffindor >= hufflepuff && gryffindor >= ravenclaw) {
        console.log("¡Has sido asignado a Gryffindor!");
    } else if (slytherin >= gryffindor && slytherin >= hufflepuff && slytherin >= ravenclaw) {
        console.log("¡Has sido asignado a Slytherin!");
    } else if (hufflepuff >= gryffindor && hufflepuff >= slytherin && hufflepuff >= ravenclaw) {
        console.log("¡Has sido asignado a Hufflepuff!");
    } else {
        console.log("¡Has sido asignado a Ravenclaw!");
    }

    rl.close(); // Cerrar la interfaz de lectura
};

iniciar();

