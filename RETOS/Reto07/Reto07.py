'''
Crea un programa que invierta el orden de una cadena de texto sin usar funciones propias del lenguaje que lo hagan de forma automática.

    - Si le pasamos "Hola mundo" nos retornaría "odnum aloH"
'''
def invertir_cadena(texto):
    caracteres = list(texto)
    longitud = len(caracteres)
    
    # Invertir el arreglo de caracteres
    for i in range(longitud // 2):
        caracteres[i], caracteres[longitud - 1 - i] = caracteres[longitud - 1 - i], caracteres[i]
    
    return ''.join(caracteres)

texto = input("Ingresa una cadena de texto: ")
print("Cadena invertida:", invertir_cadena(texto))
