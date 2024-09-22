
'''
Crea un programa que cuente el número de vocales en una frase ingresada por el usuario. El programa debe seguir estas reglas:

- Solicitar al usuario que ingrese una frase. La frase puede contener letras mayúsculas y minúsculas.
- Preguntar al usuario si quiere contar:
        
        Todas las vocales (a, e, i, o, u).
        Una vocal específica (el usuario debe ingresar cuál vocal desea contar).

- Contar el número de vocales según la elección del usuario. No debe diferenciar entre mayúsculas y minúsculas.
- Mostrar el resultado al usuario. Indicar cuántas vocales se encontraron en la frase, según la opción elegida.

Consideraciones Adicionales:

- El programa debe manejar frases vacías y mostrar un mensaje adecuado si no se encuentran vocales. 

'''
def contar_vocales(frase, tipo, vocal=None):
    contador = 0
    if tipo.lower() == "todas":
        for c in frase:
            if c.lower() in "aeiou":
                contador += 1
        return f"El número total de vocales en la frase es: {contador}"
    elif tipo.lower() == "vocal" and vocal:
        for c in frase:
            if c.lower() == vocal.lower():
                contador += 1
        return f"El número de '{vocal}' en la frase es: {contador}"
    else:
        return "Opción no válida."

frase = input("Introduce una frase: ")
tipo = input("¿Quieres contar todas las vocales o una vocal específica? (todas/vocal): ")

if tipo.lower() == "vocal":
    vocal = input("¿Cuál vocal deseas contar? (a/e/i/o/u): ")
    print(contar_vocales(frase, tipo, vocal))
else:
    print(contar_vocales(frase, tipo))
