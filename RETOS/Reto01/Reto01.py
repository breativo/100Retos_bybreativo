'''
    Reto #1
    ¿ES UN ANAGRAMA?
    Dificultad: MEDIA

    Enunciado: Escribe una función que reciba dos palabras (String) y retorne verdadero o falso (Boolean) según sean o no anagramas.
-Un Anagrama consiste en formar una palabra reordenando TODAS las letras de otra palabra inicial.
-NO hace falta comprobar que ambas palabras existan.
-Dos palabras exactamente iguales no son anagrama.
'''

def es_anagrama(palabra1, palabra2):
    # Convertir ambas palabras a minúsculas para evitar diferencias de mayúsculas y minúsculas
    palabra1 = palabra1.lower()
    palabra2 = palabra2.lower()

    # Si las palabras son exactamente iguales, no son anagramas
    if palabra1 == palabra2:
        return False

    # Verificamos si tienen la misma longitud
    if len(palabra1) != len(palabra2):
        return False

    # Ordenamos las letras de ambas palabras y las comparamos
    return sorted(palabra1) == sorted(palabra2)

print(es_anagrama("amor","roma"))
print(es_anagrama("amor", "corazon"))