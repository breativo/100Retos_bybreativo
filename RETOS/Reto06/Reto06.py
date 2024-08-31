'''
Crea una única función (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.

    - La función recibirá por parámetro sólo UN polígono a la vez.
    - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
    - Imprime el cálculo del área de un polígono de cada tipo.
'''
def calcular_area(tipo, medida1, medida2):
    if tipo.lower() == 'triangulo':
        return 0.5 * medida1 * medida2  # medida1 es la base, medida2 es la altura
    elif tipo.lower() == 'cuadrado':
        return medida1 * medida1  # medida1 es el lado
    elif tipo.lower() == 'rectangulo':
        return medida1 * medida2  # medida1 es la base, medida2 es la altura
    else:
        raise ValueError("Tipo de polígono no soportado")

# Imprimir el cálculo del área para cada tipo de polígono
print("Área del triángulo:", calcular_area('triangulo', 5, 10))  # base 5, altura 10
print("Área del cuadrado:", calcular_area('cuadrado', 4, 0))    # lado 4
print("Área del rectángulo:", calcular_area('rectangulo', 7, 3)) # base 7, altura 3
