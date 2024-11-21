
'''
Crea un programa que simule una carrera de camellos en el que el usuario selecciona uno de los siete camellos
y los camellos avanzan de acuerdo con tiradas aleatorias. El primero que llegue a la meta (casilla 10) ganará 
la carrera.
'''
import random

def carrera_de_camellos():

    camellos = [0] * 7
    meta = 10
    carrera_terminada = False
    
    print("¡Bienvenido a la carrera de camellos!")
    camello_elegido = int(input("Elige tu camello (1 a 7): ")) - 1 
    
    
    while not carrera_terminada:
    
        for i in range(7):
            carrera_visual = "-" * camellos[i] + str(i + 1) + "" * (meta - camellos[i])
            print(carrera_visual, end=" ")
        print()
        

        for i in range(7):
            if random.randint(0, 6) == i:  
                camellos[i] += 1
        

        for i in range(7):
            if camellos[i] >= meta:
                print(f"¡El camello {i + 1} ha llegado a la meta!")
                if i == camello_elegido:
                    print("¡Felicidades! Has ganado.")
                else:
                    print("¡Lo siento! Tu camello no ganó.")
                carrera_terminada = True
                break

carrera_de_camellos()
