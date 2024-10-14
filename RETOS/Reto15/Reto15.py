'''
Crea un programa que dibuje una escalera en función del número de escalones proporcionado por el usuario. El programa debe seguir las siguientes reglas:

- Si el número de escalones es positivo, la escalera será ascendente de izquierda a derecha. Cada peldaño estará compuesto por un guion bajo (_) y una barra vertical (|), con un desplazamiento hacia la derecha en cada línea.
- Si el número de escalones es negativo, la escalera será descendente de izquierda a derecha. En este caso, cada peldaño estará compuesto por una barra vertical (|) y un guion bajo (_), con un desplazamiento hacia la derecha en cada línea.
- Si el número de escalones es cero, se dibujarán dos guiones bajos (__) en dos líneas diferentes.
'''
def dibujar_escalera(n):
    if n > 0:
        # Escalera ascendente
        for i in range(n):
            print(' ' * (n - i - 1) + '_|')
    elif n < 0:
        # Escalera descendente
        for i in range(-n):
            print(' ' * i + '|_')
    else:
        # Caso especial para n == 0
        print('__')

# Función para obtener un número entero válido
def obtener_numero():
    while True:
        try:
            return int(input("Introduce el número de escalones: "))
        except ValueError:
            print("Por favor, introduce un número válido.")

# Solicitar al usuario el número de escalones
escalones = obtener_numero()
dibujar_escalera(escalones)

