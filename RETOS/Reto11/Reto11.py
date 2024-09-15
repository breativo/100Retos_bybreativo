'''
Crea un programa que simule la generación de contraseñas seguras.

El programa debe interactuar con el usuario para definir la longitud de la contraseña, permitiendo seleccionar una longitud entre 8 y 12 caracteres.

La contraseña generada debe cumplir con los siguientes requisitos mínimos:
        * Debe contener al menos una letra mayúscula.
        * Debe contener al menos una letra minúscula.
        * Debe contener al menos un número.
        * Debe contener al menos un carácter especial (por ejemplo, @, #, !, etc.).

Además, el programa deberá generar contraseñas aleatorias que respeten los criterios mencionados.

El programa presentará la contraseña generada al usuario una vez que se haya completado el proceso.

Consideraciones adicionales:

    * El programa debe validar que la longitud de la contraseña ingresada por el usuario esté dentro del rango permitido.
    * Si el usuario introduce una longitud no válida, deberá solicitarla nuevamente.
'''
import random
import string

def generate_password(length):
    upper = string.ascii_uppercase
    lower = string.ascii_lowercase
    digits = string.digits
    special = "@#&!"
    all_chars = upper + lower + digits + special

    password = [
        random.choice(upper),
        random.choice(lower),
        random.choice(digits),
        random.choice(special)
    ]

    password += random.choices(all_chars, k=length - 4)

    random.shuffle(password)
    return ''.join(password)

def main():
    length = 0
    while length < 8 or length > 12:
        length = int(input("Introduce la longitud deseada de la contraseña (entre 8 y 12 caracteres): "))

    print("Tu contraseña segura es:", generate_password(length))

if __name__ == "__main__":
    main()
