'''
Crea un programa de cuenta atrás que permita al usuario seleccionar el tiempo en segundos, desde 10 segundos hasta 60 segundos en intervalos de 10 (es decir, 10, 20, 30, 40, 50, o 60 segundos).

Especificaciones:

- El programa debe mostrar un menú de selección de tiempo, ofreciendo las opciones: 10, 20, 30, 40, 50, o 60 segundos.
- El usuario seleccionará un valor para iniciar la cuenta atrás.
- Una vez que el usuario haya seleccionado el tiempo, el programa iniciará la cuenta atrás en tiempo real, mostrando el tiempo restante cada segundo hasta llegar a cero.
- Al finalizar, el programa mostrará un mensaje indicando que la cuenta atrás ha terminado.
'''
import time

def cuenta_atras(tiempo):
    print(f"Iniciando cuenta atrás de {tiempo} segundos...")
    for i in range(tiempo, 0, -1):
        print(i)
        time.sleep(1)
    print("¡Tiempo terminado!")

def solicitar_tiempo():
    opciones = [10, 20, 30, 40, 50, 60]
    while True:
        try:
            tiempo = int(input("Seleccione el tiempo de cuenta atrás: 10, 20, 30, 40, 50, o 60 segundos\n"))
            if tiempo in opciones:
                cuenta_atras(tiempo)
                break
            else:
                print("Opción no válida. Intente de nuevo.")
        except ValueError:
            print("Entrada inválida. Por favor ingrese un número.")

solicitar_tiempo()
