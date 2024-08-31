'''
Escribe un programa que reciba un solo carácter por parte del usuario y muestre por consola (con un print) si dicho carácter es una vocal o una consonante. Si el carácter no es una letra, el programa deberá mostrar un mensaje de error.

    - Si el carácter es una vocal, mostrará: "Es una vocal".
    - Si el carácter es una consonante, mostrará: "Es una consonante".
    - Si el carácter no es una letra (números, símbolos, espacios, etc.), mostrará: "Error: No es una letra".

El programa debe funcionar tanto para letras mayúsculas como minúsculas.
'''
def clasificar_caracter(caracter):
    # Convertir a minúscula para simplificar la comparación
    c = caracter.lower()

    # Verificar si es una letra
    if c.isalpha():
        if c in "aeiou":
            return "Es una vocal."
        else:
            return "Es una consonante."
    else:
        return "Error: No es una letra."

# Leer el carácter del usuario
input_char = input("Ingresa un solo carácter: ")

if len(input_char) != 1:
    print("Error: Se debe ingresar solo un carácter.")
else:
    print(clasificar_caracter(input_char))
