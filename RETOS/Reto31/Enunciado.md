# RETO #31: MAQUINA RECREATIVA   
Dificultad:  FACIL | Lenguajes: Python, Java, JavaScript y Kotlin.

## Enunciado

```
Desarrolla un programa que simule una máquina tragaperras interactiva, donde el jugador comienza con 25 monedas y debe intentar alinear tres iconos idénticos para ganar. Un comodín especial facilita las combinaciones ganadoras al sustituir a cualquier icono. Después de cada jugada, el jugador puede decidir si seguir jugando o salir del juego. Al final, se muestran estadísticas detalladas del desempeño.

Reglas del Juego:

- Inicialización:
        El jugador comienza con 25 monedas.
        La tragaperras utiliza un conjunto de 10 iconos 5 diferentes (por ejemplo: "🍒", "🔔", "🍋", "💎", "⭐") más un comodín especial (por ejemplo, "🎲").

- Jugabilidad:
        Cada jugada cuesta 1 moneda.
        La máquina selecciona tres iconos aleatorios de entre los 5 posibles y el comodín.
        Si los tres iconos son idénticos o si el comodín completa la combinación, el jugador gana monedas equivalentes al número de monedas que tenía al momento de realizar la jugada ganadora.
        Si no acierta, pierde 1 moneda.

- Reglas del Comodín:
        El comodín 🎲 puede sustituir a cualquier icono para formar una combinación ganadora.
        Ejemplo: Si el resultado es "🍒 🎲 🍒", cuenta como un acierto (tres "🍒").

- Decisiones del Jugador:
        Después de cada jugada, el programa debe preguntar al jugador si desea:
            a Seguir jugando.
            b Salir del juego.

- Condiciones de Fin:
        El juego termina automáticamente si el saldo del jugador llega a 0 monedas.
        Si el jugador elige salir, se mostrará un resumen con estadísticas de la partida.

Estadísticas Finales:

Al finalizar el juego, se deben mostrar las siguientes estadísticas:

    Número total de jugadas realizadas.
    Cantidad total de monedas ganadas.
    Cantidad total de monedas gastadas.
    Cantidad de aciertos logrados.
    Número de combinaciones ganadoras con comodín.
    Racha más larga de partidas jugadas sin acierto.

Ejemplo de Juego:

    Inicio:
        "Bienvenido a la Máquina Tragaperras con Comodín"
        "Tienes 25 monedas. ¡Buena suerte!"

    Primera jugada (Costo: 1 moneda):
        Resultado: 🍒 🎲 💎 (No ganas).
        Mensaje: "No hubo acierto. Te quedan 24 monedas."
        Opción: "Presiona a para jugar de nuevo o b para salir."

    Segunda jugada (Costo: 1 moneda):
        Resultado: 🍒 🎲 🍒 (¡Ganaste!).
        Mensaje: "¡Felicidades! Ganaste 24 monedas. Tu saldo actual es 48 monedas."
        Opción: "Presiona a para jugar de nuevo o b para salir."

    Final:
        Si el jugador elige salir o se queda sin monedas:
            "Juego terminado. Estas son tus estadísticas:"
                Jugadas realizadas: 7
                Monedas ganadas: 50
                Monedas gastadas: 7
                Aciertos logrados: 2
                Combinaciones con comodín: 1
                Racha más larga sin aciertos: 3

```

## Respuestas y retos
Listado de los [100 retos](/README.md)

Soluciones al reto: 
[Java](/RETOS/Reto31/Reto31.java) | 
[JavaScript](/RETOS/Reto31/Reto31.js) | 
[Python](/RETOS/Reto31/Reto31.py) |
[Kotlin](/RETOS/Reto31/Reto31.kt)



## ¡Apóyame! 
#### Puedes apoyar mi trabajo haciendo "☆ Star" en el repositorio. ¡Gracias!

### En mi perfil de GitHub tienes más información

[![Web](https://img.shields.io/badge/GitHub-breativo-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://github.com/breativo)