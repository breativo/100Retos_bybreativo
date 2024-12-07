'''
Crea un programa que simule un sorteo de rifa basado en números aleatorios.
El usuario solo debe proporcionar los parámetros necesarios, y el programa 
realizará automáticamente el sorteo.
'''

import random

def main():
    print("¡Bienvenido al sorteo de la suerte!")

    inicio = int(input("Ingresa el número inicial del rango: "))
    fin = int(input("Ingresa el número final del rango: "))

    if inicio >= fin:
        print("El número inicial debe ser menor que el número final.")
        return

    ganadores = int(input("Ingresa la cantidad de ganadores: "))

    if ganadores > (fin - inicio + 1):
        print("La cantidad de ganadores no puede ser mayor que el rango de números.")
        return

    ganadores_set = set()

    while len(ganadores_set) < ganadores:
        numero = random.randint(inicio, fin)
        ganadores_set.add(numero)

    print("\nSimulando el sorteo...")
    print("🎉 Los números ganadores son: ")
    for numero in ganadores_set:
        print(f"   - {numero}")

    print("\n¡Gracias por participar en el sorteo de la rifa!")

if __name__ == "__main__":
    main()
