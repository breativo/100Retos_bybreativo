# RETO #30: CÓDIGO SECRETO    
Dificultad:  FACIL | Lenguajes: Python, Java, JavaScript y Kotlin.

## Enunciado

```
Crea un programa que, dado un mensaje de texto y una clave numérica, encripte el mensaje usando el "Cifrado César". La clave numérica indicará cuántas posiciones se deben desplazar las letras del mensaje original.
Especificaciones:

    - Entrada:
    El programa debe solicitar al usuario:
            - Un mensaje de texto (puede incluir letras mayúsculas, minúsculas y espacios).
            - Un número entero k que indica el número de posiciones que se deben desplazar las letras en el alfabeto (la clave).

    - Proceso:
    Para encriptar el mensaje, cada letra del mensaje debe ser desplazada k posiciones hacia adelante en el alfabeto.
            - Si el desplazamiento pasa por la "Z", debe volver a la "A".
            - Si el desplazamiento pasa por la "z", debe volver a la "a".
            - Los espacios y caracteres no alfabéticos (como números y puntuación) deben permanecer sin cambios.
        
    Si la clave k es mayor que 26 (el número de letras en el alfabeto), debes usar k % 26 para calcular el desplazamiento efectivo.

    - Requisitos adicionales:
    El programa debe manejar correctamente letras mayúsculas, minúsculas y caracteres especiales (espacios, signos de puntuación, etc.).
    Implementa una función separada para el encriptado y otra para la entrada y salida del programa.
    Considera que el programa debe poder funcionar con claves mayores a 26 sin errores (utilizando el módulo 26).

    - Salida:
    El programa debe mostrar el mensaje encriptado.


Ejemplo de ejecución:

Entrada:
Mensaje: "Hola Mundo"
Clave: 3

Salida:
Mensaje encriptado: "Krod Pxqgr"

```

## Respuestas y retos
Listado de los [100 retos](/README.md)

Soluciones al reto: 
[Java](/RETOS/Reto30/Reto30.java) | 
[JavaScript](/RETOS/Reto30/Reto30.js) | 
[Python](/RETOS/Reto30/Reto30.py) |
[Kotlin](/RETOS/Reto30/Reto30.kt)



## ¡Apóyame! 
#### Puedes apoyar mi trabajo haciendo "☆ Star" en el repositorio. ¡Gracias!

### En mi perfil de GitHub tienes más información

[![Web](https://img.shields.io/badge/GitHub-breativo-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://github.com/breativo)