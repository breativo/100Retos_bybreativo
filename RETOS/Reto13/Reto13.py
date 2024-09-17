'''
Crea un programa que simule un sistema de sorteo para seleccionar ganadores de una lista de participantes almacenada en un archivo de texto plano (formato .txt). 

El programa debe seguir las siguientes reglas:

    - El programa debe solicitar al usuario el nombre de un archivo de texto (.txt) que contenga una lista de nombres, donde cada nombre esté en una línea diferente. Si el archivo no existe, el programa debe mostrar un mensaje de error y solicitar nuevamente el archivo.
    - Una vez cargado el archivo correctamente, el programa debe contar la cantidad total de participantes y mostrar este número al usuario.
    - El programa debe preguntar cuántos ganadores desea seleccionar el usuario.
    - El número de ganadores no puede ser mayor que el número de participantes. Si el número de ganadores es mayor, el programa debe mostrar un mensaje de error y solicitar nuevamente el número de ganadores.
    - El programa debe seleccionar aleatoriamente a los ganadores de la lista, garantizando que no se repitan.
    - Una vez realizado el sorteo, el programa debe mostrar los nombres de los ganadores.

Consideraciones adicionales:

    - El archivo .txt debe tener un formato en el que cada nombre de participante esté en una línea distinta.
    - El programa debe validar que el archivo de texto existe y contiene al menos un participante antes de continuar.
    - Si el número de ganadores es válido, se deben seleccionar de manera aleatoria y sin repetición.
    - Los nombres de los ganadores deben mostrarse en una lista ordenada.
'''

import random

def cargar_lista(archivo):
    """Carga los nombres de un archivo de texto y devuelve una lista de nombres."""
    try:
        with open(archivo, 'r', encoding='utf-8') as f:
            nombres = f.read().splitlines()  # Lee cada línea como un nombre
        return nombres
    except FileNotFoundError:
        print("El archivo no existe. Intenta nuevamente.")
        return []

def seleccionar_ganadores(nombres, num_ganadores):
    """Selecciona aleatoriamente ganadores sin repetir."""
    return random.sample(nombres, num_ganadores)

def main():
    archivo = input("Introduce el nombre del archivo con la lista de participantes: ")
    nombres = cargar_lista(archivo)

    if len(nombres) == 0:
        return

    print(f"Se han cargado {len(nombres)} participantes.")
    
    while True:
        try:
            num_ganadores = int(input("¿Cuántos ganadores deseas seleccionar? "))
            if num_ganadores > len(nombres):
                print("El número de ganadores no puede ser mayor al número de participantes.")
            else:
                break
        except ValueError:
            print("Por favor, introduce un número válido.")

    ganadores = seleccionar_ganadores(nombres, num_ganadores)
    print("\nLos ganadores seleccionados son:")
    for i, ganador in enumerate(ganadores, 1):
        print(f"{i}. {ganador}")

if __name__ == "__main__":
    main()
