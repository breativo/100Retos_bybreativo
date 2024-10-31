'''
Crea un programa que calcule y retorne cuántos días hay entre dos fechas dadas como cadenas de texto. La segunda fecha siempre debe ser posterior a la primera, de lo contrario, se solicitará ingresar nuevamente ambas fechas en el formato correcto.

Especificaciones:

    - El programa recibirá dos cadenas de texto en el formato "dd-MM-yyyy", representando las fechas a comparar.
    - Si la segunda fecha es anterior a la primera, el programa solicitará ambas fechas de nuevo hasta que la segunda sea mayor que la primera.
    - La función debe calcular la diferencia en días y retornar un valor entero (Int).
    - Si alguna de las dos cadenas no representa una fecha válida en el formato correcto, el programa debe lanzar una excepción.
'''
from datetime import datetime

def get_date_input(prompt):
    while True:
        date_str = input(prompt)
        try:
            return datetime.strptime(date_str, "%d-%m-%Y")
        except ValueError:
            print("Formato de fecha incorrecto. Intente de nuevo.")

def main():
    while True:
        fecha1 = get_date_input("Ingrese la primera fecha (dd-MM-yyyy): ")
        fecha2 = get_date_input("Ingrese la segunda fecha (dd-MM-yyyy): ")

        if fecha2 > fecha1:
            break
        else:
            print("La segunda fecha debe ser mayor que la primera. Intente de nuevo.")

    diferencia_dias = abs((fecha2 - fecha1).days)
    print("Diferencia en días:", diferencia_dias)

if __name__ == "__main__":
    main()
