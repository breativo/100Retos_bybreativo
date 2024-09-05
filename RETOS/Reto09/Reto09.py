'''
Desarrolla un programa que determine quién gana más partidas en el juego "Piedra, Papel o Tijera". El resultado final puede ser "Jugador 1", "Jugador 2" o "Empate". La función debe recibir como entrada una lista de pares, donde cada par representa una jugada realizada por el Jugador 1 y el Jugador 2. Cada jugada se representará mediante las siguientes opciones:

    "Piedra"
    "Papel"
    "Tijera"

El programa debe comparar las jugadas de cada par, determinar el ganador de cada partida, contabilizar las victorias de cada jugador, y finalmente devolver quién ganó más partidas, o si hubo un empate.

Ejemplo de Entrada:
[("Piedra", "Tijera"), ("Tijera", "Piedra"), ("Papel", "Tijera")]

Pistas:
Recuerda las reglas básicas del juego: Piedra vence a Tijera, Tijera vence a Papel, y Papel vence a Piedra.
'''
import random

partida = ["piedra", "papel", "tijera"]
contador = 0; contadorUsuario = 0; contadorOponente = 0
numeroPartidas = 8

while contador < numeroPartidas:
    # Seleccionar jugada aleatoria para el usuario y el oponente
    usuario = random.choice(partida)
    oponente = random.choice(partida)

    print("Usuario: " + usuario)
    print("Oponente: " + oponente)

    # Comparar las jugadas
    if usuario == oponente:
        print("¡Es un empate!")
    elif (usuario == "piedra" and oponente == "tijera") or \
        (usuario == "papel" and oponente == "piedra") or \
        (usuario == "tijera" and oponente == "papel"):
        print("¡Usuario gana!")
        contadorUsuario += 1
    else:
        print("¡Oponente gana!")
        contadorOponente += 1

    if contadorUsuario == 3:
        print("Ganador final el usuario!🎉🎉🎉")
        break
    if contadorOponente == 3:
        print("Ganador final el oponente!🎉🎉🎉")
        break
print("Partida finalizada")