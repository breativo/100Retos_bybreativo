'''
 * Crea un programa que cuente cuantas veces se repite cada palabra
 * y que muestre el recuento final de todas ellas.
 * - Los signos de puntuación no forman parte de la palabra.
 * - Una palabra es la misma aunque aparezca en mayúsculas y minúsculas.
 * - No se pueden utilizar funciones propias del lenguaje que
 *   lo resuelvan automáticamente.
'''
import string

def contar_palabras(texto):
    # Convertir a minúsculas y eliminar signos de puntuación
    texto_limpio = texto.lower().translate(str.maketrans('', '', string.punctuation))

    # Dividir el texto en palabras
    palabras = texto_limpio.split()

    # Usar un diccionario para contar las palabras
    contador_palabras = {}

    for palabra in palabras:
        if palabra:
            if palabra in contador_palabras:
                contador_palabras[palabra] += 1
            else:
                contador_palabras[palabra] = 1

    return contador_palabras

# Leer el texto del usuario
texto = input("Ingresa el texto: ")

# Contar palabras y mostrar resultados
conteo = contar_palabras(texto)
for palabra, cantidad in conteo.items():
    print(f"{palabra}: {cantidad}")
