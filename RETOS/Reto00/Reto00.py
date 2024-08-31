
'''
    Reto #0
    EL FAMOSO "FIZZ BUZZ"
    Dificultad: FÁCIL

    Enunciado: Escribe un programa que muestre por consola (con un print) los números de 1 a 100 (ambos incluidos y con un salto de línea entre cada impresión), sustituyendo los siguientes:
- Múltiplos de 3 por la palabra "fizz".
- Múltiplos de 5 por la palabra "buzz".
- Múltiplos de 3 y de 5 a la vez por la palabra "fizzbuzz".

'''
# Rango de 1 a 100
for i in range(1,101): 
    # Sentencia condicional para comprobar si es múltiplo de 3, 5 o ambos.
    if i % 3 == 0 and i % 5 == 0: 
        # Mostramos el resultado de la sentencia condicional por consola
        print("fizzbuzz") 
    elif i % 3 == 0:
        print("fizz")
    elif i % 5 == 0:
        print("buzz")
    else:
        print(i)