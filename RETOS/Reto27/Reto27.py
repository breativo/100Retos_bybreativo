'''
Crea un programa que simule un juego de bingo en el que los cartones tienen un formato 5x1 (5 columnas y 1 filas). 
Los números en los cartones y las extracciones se generan en el rango de 1 a 50.
El objetivo es que los jugadores compitan hasta que uno logre tachar todos los números de su cartón.
'''
import random
import time

def generar_carton():
    """
    Genera un cartón con una fila de 5 números dentro de rangos específicos.
    """
    return [
        random.randint(0, 10),    
        random.randint(11, 20),  
        random.randint(21, 30),     
        random.randint(31, 40),   
        random.randint(41, 50)      
    ]

def es_ganador(carton):
    """
    Verifica si todos los números del cartón han sido marcados con 'X'.
    """
    return all(num == 'X' for num in carton)

def main():
    print("¡Bienvenido al juego de Bingo!")

    # Solicitar número de jugadores
    num_jugadores = int(input("Ingrese el número de jugadores: "))
    jugadores = []
    cartones = {}

    # Solicitar nombres y generar cartones
    for i in range(num_jugadores):
        nombre = input(f"Ingrese el nombre del jugador {i + 1}: ")
        jugadores.append(nombre)
        cartones[nombre] = generar_carton()

    # Mostrar cartones iniciales
    print("\nCartones generados:")
    for jugador in jugadores:
        print(f"{jugador}: {cartones[jugador]}")

    print("\n¡Comienza el juego!")
    numeros_cantados = set()
    hay_ganador = False

    # Iniciar bucle del juego
    while not hay_ganador:
        # Generar número aleatorio no repetido
        numero = random.randint(0, 50)
        while numero in numeros_cantados:
            numero = random.randint(0, 50)
        numeros_cantados.add(numero)

        print(f"\nNúmero cantado: {numero}")

        # Verificar si algún jugador tiene el número
        for jugador in jugadores:
            carton = cartones[jugador]
            if numero in carton:
                index = carton.index(numero)
                carton[index] = 'X'
                print(f"{jugador} tiene el número {numero} en su cartón.")
            else:
                print(f"{jugador} no tiene el número {numero}.")

            # Verificar si el jugador ganó
            if es_ganador(carton):
                print(f"\n¡{jugador} ha hecho Bingo y es el ganador!")
                hay_ganador = True
                break

        if not hay_ganador:
            # Mostrar estado de los cartones
            print("\nEstado de los cartones:")
            for jugador in jugadores:
                print(f"{jugador}: {cartones[jugador]}")
            print("Esperando 10 segundos para el siguiente número...")
            time.sleep(10)

    print("¡Gracias por jugar al Bingo!")

if __name__ == "__main__":
    main()
