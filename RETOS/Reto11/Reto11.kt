/*
 * Crea un programa que simule la generación de contraseñas seguras.

*El programa debe interactuar con el usuario para definir la longitud de la contraseña, permitiendo seleccionar una longitud entre 8 y 12 caracteres.

*La contraseña generada debe cumplir con los siguientes requisitos mínimos:
        * Debe contener al menos una letra mayúscula.
        * Debe contener al menos una letra minúscula.
        * Debe contener al menos un número.
        * Debe contener al menos un carácter especial (por ejemplo, @, #, !, etc.).

*Además, el programa deberá generar contraseñas aleatorias que respeten los criterios mencionados.

*El programa presentará la contraseña generada al usuario una vez que se haya completado el proceso.

*Consideraciones adicionales:
    * El programa debe validar que la longitud de la contraseña ingresada por el usuario esté dentro del rango permitido.
    * Si el usuario introduce una longitud no válida, deberá solicitarla nuevamente.
 */

import java.util.Random
import java.util.Scanner

fun generatePassword(length: Int): String {
    val upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lower = "abcdefghijklmnopqrstuvwxyz"
    val digits = "0123456789"
    val special = "@#&!"
    val allChars = upper + lower + digits + special

    val random = Random()
    val password = StringBuilder()

    password.append(upper[random.nextInt(upper.length)])
    password.append(lower[random.nextInt(lower.length)])
    password.append(digits[random.nextInt(digits.length)])
    password.append(special[random.nextInt(special.length)])

    for (i in 4 until length) {
        password.append(allChars[random.nextInt(allChars.length)])
    }

    return password.toString()
}

fun main() {
    val scanner = Scanner(System.`in`)
    var length = 0

    while (length < 8 || length > 12) {
        print("Introduce la longitud deseada de la contraseña (entre 8 y 12 caracteres): ")
        length = scanner.nextInt()
    }

    println("Tu contraseña segura es: ${generatePassword(length)}")
}
