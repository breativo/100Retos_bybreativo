'''
Desarrollar un programa que seleccione una palabra aleatoria de un archivo de texto (.txt) y oculte el 50% de las letras de la palabra. El usuario deberá adivinar las letras faltantes, teniendo un máximo de 2 errores permitidos. Si introduce una letra incorrecta por tercera vez, perderá el juego.

Descripción del Ejercicio:

- El programa leerá un archivo de texto (palabras.txt) que contiene una lista de palabras (una palabra por línea).
- Seleccionará aleatoriamente una palabra del archivo.
- Ocultará el 50% de las letras de la palabra seleccionada, mostrando los espacios en blanco como guiones bajos (_).

'''
import random

def leer_palabras(nombre_archivo):
    with open(nombre_archivo, 'r') as archivo:
        return [linea.strip() for linea in archivo.readlines()]

def ocultar_palabra(palabra):
    longitud = len(palabra)
    # Calcular el número de letras a ocultar (50%)
    num_a_ocultar = longitud // 2
    indices_ocultos = random.sample(range(longitud), num_a_ocultar)

    return ''.join(['_' if i in indices_ocultos else letra for i, letra in enumerate(palabra)])

def mostrar_palabra(palabra, letras_adivinadas):
    return ''.join([letra if letra in letras_adivinadas else '_' for letra in palabra])

palabras = leer_palabras('palabras.txt')
palabra = random.choice(palabras)
letras_erroneas = set()
letras_adivinadas = set()
errores = 0

# Ocultar 50% de la palabra
palabra_oculta = ocultar_palabra(palabra)

print(f'Palabra: {palabra_oculta}')  # Muestra la palabra con 50% visible

while errores < 2:
    letra = input('Introduce una letra: ').lower()  

    if letra in palabra:
        letras_adivinadas.add(letra)  
        print(f'¡Bien! Has acertado la letra: {letra}')
    else:
        if letra not in letras_erroneas: 
            letras_erroneas.add(letra)
            errores += 1
            print(f'¡Fallaste! Letras incorrectas: {", ".join(letras_erroneas)}')
        else:
            print(f'Ya has intentado la letra: {letra}')


    palabra_mostrada = mostrar_palabra(palabra, letras_adivinadas)
    print(f'Palabra: {palabra_mostrada}')

    if palabra_mostrada == palabra:
        print(f'¡Felicidades! Has adivinado la palabra: {palabra}')
        break

if errores == 2:
    print(f'Has perdido. La palabra era: {palabra}')
