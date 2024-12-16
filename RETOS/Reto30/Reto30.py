def encriptar_mensaje(mensaje, clave):
    mensaje_encriptado = ""
    clave = clave % 26  # Asegurar que la clave sea dentro de 0-25

    for caracter in mensaje:
        # Encriptar solo letras
        if caracter.isalpha():
            base = 'a' if caracter.islower() else 'A'
            caracter = chr((ord(caracter) - ord(base) + clave) % 26 + ord(base))

        mensaje_encriptado += caracter

    return mensaje_encriptado


# Solicitar al usuario el mensaje y la clave
mensaje = input("Introduce el mensaje: ")
clave = int(input("Introduce la clave: "))

# Encriptar el mensaje
mensaje_encriptado = encriptar_mensaje(mensaje, clave)

# Mostrar el mensaje encriptado
print("Mensaje encriptado:", mensaje_encriptado)
