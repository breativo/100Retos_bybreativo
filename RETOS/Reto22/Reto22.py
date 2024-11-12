import random

'''
Desarrolla un programa de "Juego de Dados" estilo casino en el que el jugador comienza con 10 "patos" 
como fondos iniciales. El jugador puede apostar la cantidad de patos que desee en cada ronda, tratando 
de acertar la suma de los dos dados lanzados. El juego continúa hasta que el jugador se quede sin patos, 
momento en el cual la partida termina automáticamente.
'''

def jugar():
    patos = 10
    print("Bienvenido al Juego de Dados. ¡Tienes 10 patos!")

    while patos > 0:
        print(f"Saldo actual: {patos} patos.")
        apuesta = int(input("¿Cuántos patos deseas apostar? "))

        if apuesta > patos or apuesta <= 0:
            print("Apuesta no válida. Inténtalo de nuevo.")
            continue

        suma_elegida = int(input("Elige una suma entre 2 y 12: "))

        if suma_elegida < 2 or suma_elegida > 12:
            print("Suma no válida. Inténtalo de nuevo.")
            continue

        dado1 = random.randint(1, 6)
        dado2 = random.randint(1, 6)
        suma_dados = dado1 + dado2

        print(f"Lanzaste los dados: Dado 1 = {dado1}, Dado 2 = {dado2}, Suma = {suma_dados}")

        if suma_dados == suma_elegida:
            patos += apuesta * 2
            print(f"¡Felicidades, acertaste! Ganaste {apuesta * 2} patos.")
        else:
            patos -= apuesta
            print(f"No acertaste. Perdiste {apuesta} patos.")

    print("Lo siento, te has quedado sin patos. ¡La partida ha terminado!")

jugar()
