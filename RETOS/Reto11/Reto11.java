package RETOS.Reto11;

import java.util.Random;
import java.util.Scanner;

public class Reto11 {
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
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int length = 0;

    while (length < 8 || length > 12) {
        System.out.print("Introduce la longitud deseada de la contraseña (entre 8 y 12 caracteres): ");
        length = scanner.nextInt();
    }

    System.out.println("Tu contraseña segura es: " + generatePassword(length));
}

public static String generatePassword(int length) {
    String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lower = "abcdefghijklmnopqrstuvwxyz";
    String digits = "0123456789";
    String special = "@#&!";
    String allChars = upper + lower + digits + special;

    Random random = new Random();
    StringBuilder password = new StringBuilder();

    password.append(upper.charAt(random.nextInt(upper.length())));
    password.append(lower.charAt(random.nextInt(lower.length())));
    password.append(digits.charAt(random.nextInt(digits.length())));
    password.append(special.charAt(random.nextInt(special.length())));

    for (int i = 4; i < length; i++) {
        password.append(allChars.charAt(random.nextInt(allChars.length())));
    }

    return password.toString();
}
}
