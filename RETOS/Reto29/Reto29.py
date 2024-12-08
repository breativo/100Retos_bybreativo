'''
Crea un programa que genere automáticamente una matriz cuadrada de dimensiones impares (3x3, 5x5, 7x7, etc.) con números enteros que formen una espiral. El número 1 debe colocarse en el centro de la matriz, y los números restantes deben expandirse en espiral hacia afuera en sentido horario.

Especificaciones:

    - Entrada del Usuario:
        Solicitar al usuario un número impar nn que representa el tamaño de la matriz (por ejemplo, 3, 5, 7, etc.).
        El programa debe validar que el número ingresado sea impar y mayor o igual a 3.

    - Generación de la Matriz:
        La matriz generada debe tener n×nn×n elementos.
        El número 1 debe ubicarse en el centro de la matriz.
        Los números restantes (2,3,4,…2,3,4,…) deben rellenar la matriz en forma de espiral hacia afuera en sentido horario.

    - Salida del Programa:
        Imprimir la matriz generada en formato legible.

        Ejemplo con n=5:

        17 16 15 14 13
        18  5  4  3 12
        19  6  1  2 11
        20  7  8  9 10
        21 22 23 24 25
'''

def generate_spiral_matrix(size):
    matrix = [[0] * size for _ in range(size)]

    x, y = size // 2, size // 2

    num = 1
    matrix[x][y] = num  
    num += 1

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    steps = 1
    direction = 0  

    while num <= size * size:
        for _ in range(steps):
            x += dx[direction]
            y += dy[direction]

            if 0 <= x < size and 0 <= y < size:
                matrix[x][y] = num
                num += 1

        direction = (direction + 1) % 4

        if direction == 0 or direction == 2:
            steps += 1

    return matrix

def print_matrix(matrix):
    for row in matrix:
        print(" ".join(f"{num:3}" for num in row))

size = int(input("Ingresa el tamaño de la matriz (impar): "))
if size % 2 == 0 or size < 3:
    raise ValueError("El tamaño debe ser un número impar mayor o igual a 3.")

matrix = generate_spiral_matrix(size)
print_matrix(matrix)
