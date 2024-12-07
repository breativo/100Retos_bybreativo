# RETO #27: LINEA O BINGO
Dificultad:  DIFÍCIL | Lenguajes: Python, Java, JavaScript y Kotlin.

## Enunciado

```
 Crea un programa que simule un juego de bingo en el que los cartones tienen un formato 5x1 (5 columnas y 1 filas). Los números en los cartones y las extracciones se generan en el rango de 1 a 50. El objetivo es que los jugadores compitan hasta que uno logre tachar todos los números de su cartón.

Requisitos del programa:

    - Inicio del juego
        Solicitar el número de jugadores y sus nombres.
        Validar que el número de jugadores sea al menos 1 y que cada jugador tenga al menos 1 cartón.

    - Generación de cartones (formato 5x1)
        Los números en las posiciones se generan de forma aleatoria dentro de estos rangos:
            Primera posición: 0-10
            Segunda posición: 11-20
            Tercera posición: 21-30
            Cuarta posición: 31-40
            Quinta posición: 41-50

        Los números no deben repetirse dentro del cartón.
        Mostrar los cartones generados para cada jugador.

    - Desarrollo del juego
        Los números se extraerán aleatoriamente, uno cada 10 segundos.
        Después de cada extracción, actualizar los cartones de los jugadores marcando el número con una "X" si coincide.
        Mostrar el estado de todos los cartones después de cada extracción.

    - Finalización del juego
        El juego termina cuando un jugador tacha todos los números de su cartón.
        Felicitar al ganador y mostrar su nombre junto con su cartón ganador completamente marcado con "X".
        Mostrar un mensaje de cierre del juego.

Simulación del Programa

🎉 ¡Bienvenido al Juego de Bingo! 🎉  
Por favor, ingresa la información inicial.

Entrada de datos:

Número de jugadores: 2  
Nombre del jugador 1: Ana  
Nombre del jugador 2: Luis  
 

Generando cartones...

Cartones iniciales (formato 5x1):

Cartón de Ana:
10  20  30  40  50


Cartón de Luis:
1  11 21  31  41   


Número extraído: 10
Ana  tiene en su cartón el numero 10.
Luis no tiene en su cartón el número 10.

Cartón de Ana:
X  20  30  40  50


Cartón de Luis:
1  11 21  31  41


Final del juego:

🎉 ¡Bingo! 🎉  
Ganador: Ana  

Cartón ganador:
X  X  X  X  X


¡Gracias por jugar al Bingo!
```

## Respuestas y retos
Listado de los [100 retos](/README.md)

Soluciones al reto: 
[Java](/RETOS/Reto27/Reto27.java) | 
[JavaScript](/RETOS/Reto27/Reto27.js) | 
[Python](/RETOS/Reto27/Reto27.py) |
[Kotlin](/RETOS/Reto27/Reto27.kt)



## ¡Apóyame! 
#### Puedes apoyar mi trabajo haciendo "☆ Star" en el repositorio. ¡Gracias!

### En mi perfil de GitHub tienes más información

[![Web](https://img.shields.io/badge/GitHub-breativo-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://github.com/breativo)