import random

'''
Crea un programa que simule una carrera de obstáculos para un único atleta, quien debe completar un circuito de 20 tramos. El circuito se genera aleatoriamente y contiene tramos de suelo ("_") y vallas ("|"). El atleta solo puede ingresar las acciones "run" para correr y "jump" para saltar.

Circuito:

    - El circuito consta de 20 tramos generados aleatoriamente. Cada tramo puede ser suelo ("_") o valla ("|") con una probabilidad de 50% para cada uno.

Acciones del Atleta:

    - El atleta solo puede ingresar "run" o "jump". Si escribe mal una acción o elige incorrectamente, se considera un fallo.

Tiempo y Penalización:

    - Cada tramo correcto añade 1 segundo al tiempo total.
    Cada fallo (acción incorrecta o error de escritura) añade una penalización de 2 segundos adicionales.
    - Al finalizar el circuito, el programa muestra el tiempo total y el número de fallos cometidos.
    
'''
def generar_pista():
    return "".join(random.choice(["_", "|"]) for _ in range(20))


nombre = input("Ingrese el nombre del atleta: ")


circuito = generar_pista()
print(f"Circuito generado: {circuito}")


tiempo_total = 0
fallos = 0


for i, tramo in enumerate(circuito):
    accion = input(f"Tramo {i+1} ({'suelo' if tramo == '_' else 'valla'}): ").strip().lower()

    if (tramo == "_" and accion == "run") or (tramo == "|" and accion == "jump"):
        tiempo_total += 1  
    else:
        tiempo_total += 3  
        fallos += 1

# Resultados finales
print(f"Tiempo total de {nombre}: {tiempo_total} segundos")
print(f"Fallos de {nombre}: {fallos}")
