
'''
Escribe un programa que muestre cómo transcurre un juego de tenis y quién lo ha ganado.
El programa recibirá una secuencia formada por "P1" (Player 1) o "P2" (Player 2), según quien gane cada punto del juego.

- Las puntuaciones de un juego son 00, 15, 30, 40, "Deuce" (empate), ventaja.
- Ante la secuencia [P1, P1, P2, P2, P1, P2, P1, P1], el programa mostraría lo siguiente:
    15 - 00
    30 - 00
    30 - 15
    30 - 30
    40 - 30
    Deuce
    Ventaja P1
    Ha ganado el P1
- Si quieres, puedes controlar errores en la entrada de datos.   
- Consulta las reglas del juego si tienes dudas sobre el sistema de puntos.   
'''
import random

def mostrar_puntuacion_tenis(cantidad_de_puntos):
    puntuacion = ["00", "15", "30", "40"]
    p1 = 0
    p2 = 0
    ventaja = ""

    for _ in range(cantidad_de_puntos):
        punto_ganado = "P1" if random.choice([True, False]) else "P2"

        # Incrementar la puntuación del jugador que ganó el punto
        if punto_ganado == "P1":
            p1 += 1
        else:
            p2 += 1
        
        #Verificar si alguno de los jugadores ha ganado con la condición de 5 puntos
        if p1 == 5 and p2 <=3:
            print("Ha ganado el P1")
            return
        
        if p2 == 5 and p1 <=3:
            print("Ha ganado el P2")
            return

        # Determinar el estado del juego
        if p1 >= 4 or p2 >= 4:
            if p1 == p2:
                # Regresar a "Deuce" si el puntaje está empatado después de 40
                print("Deuce")
                ventaja = ""
            elif p1 == p2 + 1:
                # Ventaja para P1
                print("Ventaja P1")
                ventaja = "P1"
            elif p2 == p1 + 1:
                # Ventaja para P2
                print("Ventaja P2")
                ventaja = "P2"
            elif p1 >= p2 + 2 and ventaja == "P1":
                # Ganador P1
                print("Ha ganado el P1")
                return
            elif p2 >= p1 + 2 and ventaja == "P2":
                # Ganador P2
                print("Ha ganado el P2")
                return
        else:
            # Mostrar la puntuación habitual antes de llegar a "40"
            print(f"{puntuacion[min(p1, 3)]} - {puntuacion[min(p2, 3)]}")

    # En caso de que haya "Ventaja" y luego se empate de nuevo
    if p1 >= 3 and p2 >= 3 and ventaja and p1 == p2:
        print("Deuce")

# Ejecutar la simulación
mostrar_puntuacion_tenis(20)  # Puedes ajustar el número de puntos generados
