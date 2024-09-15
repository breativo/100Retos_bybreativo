'''
Crea un programa que simule un juego para encontrar un número oculto. El programa debe seguir las siguientes reglas:

El número oculto será un número entero aleatorio entre 0 y 100.
El usuario tendrá 5 vidas al comenzar el juego.
En cada intento, el usuario debe ingresar un número entre 0 y 100.
Si el número ingresado no es correcto:
    - El programa restará 1 vida.
    - El programa dará una pista, indicando si el número oculto es más alto o más bajo que el número ingresado.
Si el usuario agota las 5 vidas, el programa mostrará un mensaje de "¡Has perdido!" y revelará el número oculto.
Si el usuario adivina el número oculto antes de quedarse sin vidas, el programa mostrará un mensaje de "¡Has ganado!".

Consideraciones adicionales:

El programa debe validar que el número ingresado por el usuario esté dentro del rango permitido (0 - 100). Si el usuario introduce un número fuera del rango, deberá volver a solicitarlo sin penalizar vidas.
Cada vez que el usuario pierda una vida, el programa debe mostrar cuántas vidas le quedan.
Cuando el usuario gane o pierda, el programa deberá terminar indicando el número oculto y la cantidad de intentos utilizados (si ganó).

'''

import random

def jugar():
    numero_oculto = random.randint(0, 100)
    vidas = 5
    intentos = 0

    print("El número oculto está entre 0 y 100.")
    print("Tienes 5 vidas.")

    while vidas > 0:
        try:
            intento = int(input("Introduce tu número: "))
        except ValueError:
            print("Por favor, introduce un número válido.")
            continue
        
        intentos += 1

        if intento < 0 or intento > 100:
            print("El número debe estar entre 0 y 100.")
            continue

        if intento == numero_oculto:
            print(f"¡Has adivinado el número oculto! ¡Has ganado en {intentos} intentos!")
            break
        else:
            vidas -= 1
            if intento < numero_oculto:
                print("El número oculto es más alto.")
            else:
                print("El número oculto es más bajo.")

            if vidas > 0:
                print(f"Te quedan {vidas} vidas.")
            else:
                print(f"¡Has perdido! El número oculto era: {numero_oculto}")

if __name__ == "__main__":
    jugar()
