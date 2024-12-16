package RETOS.Reto30;

import java.util.Scanner;

public class Reto30 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el mensaje: ");
        String mensaje = scanner.nextLine();
        System.out.print("Introduce la clave: ");
        int clave = scanner.nextInt();
        String mensajeEncriptado = encriptarMensaje(mensaje, clave);
        System.out.println("Mensaje encriptado: " + mensajeEncriptado);
    }

    public static String encriptarMensaje(String mensaje, int clave) {
        StringBuilder mensajeEncriptado = new StringBuilder();
        clave = clave % 26; 
        for (int i = 0; i < mensaje.length(); i++) {
            char caracter = mensaje.charAt(i);
            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                caracter = (char) (base + (caracter - base + clave) % 26);
            }
            mensajeEncriptado.append(caracter);
        }
        return mensajeEncriptado.toString();
    }
}

