import random

'''
Desarrolla un programa que simule un juego de cartas en el que participan el usuario contra a maquina. El jugador principal deberá introducir su nombre para jugar contra el sistema. El objetivo es acercarse lo más posible a 21 puntos sin pasarse.

Reglas del juego:

- Cada jugador comienza con una mano vacía y va recibiendo cartas una por una.
- El valor de las cartas numéricas (2-10) es el mismo que el número de la carta.
- Las figuras (J, Q, K) valen 10 puntos cada una.
- El As (A) vale 1 punto.
- Los jugadores pueden elegir si desean recibir más cartas o plantarse en cualquier momento.
- El juego finaliza cuando todos los jugadores se plantan o cuando un jugador supera los 21 puntos, en cuyo caso queda eliminado.

Objetivo:

- El jugador que quede más cerca de 21 puntos sin pasarse es el ganador.
- Si todos los jugadores se pasan, no hay ganador.
'''
def get_random_card():
    return min(random.randint(1, 13), 10)

def determine_winner(name, player_score, machine_score):
    print(f"\nPuntuación final: {name}: {player_score}, Máquina: {machine_score}")
    if player_score > machine_score:
        print(f"\n¡Has ganado, {name}!")
    elif machine_score > player_score:
        print("\nLa máquina ha ganado.")
    else:
        print("\nEs un empate.")

def play_blackjack():
    player_score = 0
    machine_score = 0
    player_stand = False
    machine_stand = False

    name = input("Introduce tu nombre: ")

    while not player_stand or not machine_stand:
        if not player_stand:
            answer = input("\n¿Quieres sacar una carta? (s/n): ").lower()
            if answer == 'n':
                player_stand = True
            else:
                card = get_random_card()
                player_score += card
                print(f"Has sacado un {card}. Total: {player_score}")
                if player_score > 21:
                    print(f"{name}, tu total es {player_score}. Has perdido.")
                    return

        if not machine_stand:
            if machine_score < 17:
                card = get_random_card()
                machine_score += card
                print(f"La máquina ha sacado un {card}. Total de la máquina: {machine_score}")
                if machine_score > 21:
                    print("La máquina ha perdido. ¡Has ganado!")
                    return
            else:
                machine_stand = True
                print("La máquina se planta.")

    determine_winner(name, player_score, machine_score)

play_blackjack()
