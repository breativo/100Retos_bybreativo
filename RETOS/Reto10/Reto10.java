package RETOS.Reto10;

import java.util.Scanner;

public class Reto10 {
    /*
    * Crea un programa que simule el comportamiento del sombrero seleccionador del universo mágico de Harry Potter.

    *- De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
    *- Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
    *- En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que coloque al alumno en una de las 4 casas de Hogwarts (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
    *- Ten en cuenta los rasgos de cada casa para hacer las preguntas y crear el algoritmo seleccionador.

    *Por ejemplo, en Slytherin se premia la ambición y la astucia.
     */



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gryffindor = 0, slytherin = 0, hufflepuff = 0, ravenclaw = 0;
        System.out.println("El sombrero seleccionador te asignara una casa dependiendo de tus respuestas:");
        // Preguntas
        System.out.println("Pregunta 1: ¿Qué valoras más en un proyecto?");
        System.out.println("1) Coraje");
        System.out.println("2) Ambición");
        System.out.println("3) Lealtad");
        System.out.println("4) Intelecto");
        int respuesta1 = scanner.nextInt();

        // Asignar puntos en función de la respuesta
        if (respuesta1 == 1) gryffindor++;
        else if (respuesta1 == 2) slytherin++;
        else if (respuesta1 == 3) hufflepuff++;
        else if (respuesta1 == 4) ravenclaw++;

        // Pregunta 2...
        System.out.println("Pregunta 2: ¿Qué prefieres?");
        System.out.println("1) Liderar");
        System.out.println("2) Manipular las reglas a tu favor");
        System.out.println("3) Ayudar a otros");
        System.out.println("4) Buscar el conocimiento");
        int respuesta2 = scanner.nextInt();

        if (respuesta2 == 1) gryffindor++;
        else if (respuesta2 == 2) slytherin++;
        else if (respuesta2 == 3) hufflepuff++;
        else if (respuesta2 == 4) ravenclaw++;

        // Pregunta 3
        System.out.println("Pregunta 3: ¿Cómo afrontas un problema?");
        System.out.println("1) Con valor, enfrentándolo directamente");
        System.out.println("2) Con astucia, buscando soluciones alternativas");
        System.out.println("3) Con paciencia, trabajando duro hasta resolverlo");
        System.out.println("4) Con análisis profundo, buscando aprender más sobre el problema");
        int respuesta3 = scanner.nextInt();

        if (respuesta3 == 1) gryffindor++;
        else if (respuesta3 == 2) slytherin++;
        else if (respuesta3 == 3) hufflepuff++;
        else if (respuesta3 == 4) ravenclaw++;

        // Pregunta 4
        System.out.println("Pregunta 4: ¿Cuál es tu entorno de trabajo ideal?");
        System.out.println("1) Un equipo unido y valiente");
        System.out.println("2) Un equipo competitivo y ambicioso");
        System.out.println("3) Un equipo colaborador y trabajador");
        System.out.println("4) Un equipo intelectual y creativo");
        int respuesta4 = scanner.nextInt();

        if (respuesta4 == 1) gryffindor++;
        else if (respuesta4 == 2) slytherin++;
        else if (respuesta4 == 3) hufflepuff++;
        else if (respuesta4 == 4) ravenclaw++;

        // Pregunta 5
        System.out.println("Pregunta 5: ¿Qué te motiva más en un proyecto?");
        System.out.println("1) El desafío y el coraje para enfrentarlo");
        System.out.println("2) El poder y el éxito que puedes obtener");
        System.out.println("3) El compromiso y la dedicación al equipo");
        System.out.println("4) El conocimiento y la oportunidad de aprender algo nuevo");
        int respuesta5 = scanner.nextInt();

        if (respuesta5 == 1) gryffindor++;
        else if (respuesta5 == 2) slytherin++;
        else if (respuesta5 == 3) hufflepuff++;
        else if (respuesta5 == 4) ravenclaw++;

        // Determinar casa
        if (gryffindor >= slytherin && gryffindor >= hufflepuff && gryffindor >= ravenclaw) {
            System.out.println("¡Has sido asignado a Gryffindor!");
        } else if (slytherin >= gryffindor && slytherin >= hufflepuff && slytherin >= ravenclaw) {
            System.out.println("¡Has sido asignado a Slytherin!");
        } else if (hufflepuff >= gryffindor && hufflepuff >= slytherin && hufflepuff >= ravenclaw) {
            System.out.println("¡Has sido asignado a Hufflepuff!");
        } else {
            System.out.println("¡Has sido asignado a Ravenclaw!");
        }
        scanner.close();
    }
}
