import unicodedata

'''
Crea un programa que determine si un texto ingresado es un palíndromo.

El programa pedirá al usuario que ingrese una frase o palabra y verificará si es un palíndromo.

    "Un palíndromo es una palabra o frase que se lee igual de izquierda a derecha que de derecha a izquierda, sin tener en cuenta espacios, signos de puntuación ni tildes."

Detalles de Implementación:

    - Solicitar al usuario una frase o palabra.
    - Procesar el texto para ignorar:
        * Espacios en blanco.
        * Signos de puntuación (ej., comas, puntos, signos de interrogación).
        * Tildes (considerando las letras acentuadas como sus equivalentes sin tilde).
    
    - Comparar el texto procesado:
        * Si el texto es igual al leerlo de izquierda a derecha y de derecha a izquierda, es un palíndromo.
        * Si no, no es un palíndromo.
'''
def is_palindrome(text):
    clean_text = ''.join(
        char for char in unicodedata.normalize('NFD', text)
        if unicodedata.category(char) != 'Mn' and char.isalpha()
    ).lower()

    
    return clean_text == clean_text[::-1]

input_text = input("Ingrese una frase o palabra: ")
if is_palindrome(input_text):
    print("PALÍNDROMO")
else:
    print("NO ES PALÍNDROMO")
