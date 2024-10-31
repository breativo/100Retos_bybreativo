package RETOS.Reto20;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class Reto20 {
    
    /*
    * Crea un programa que calcule y retorne cuántos días hay entre dos fechas dadas como cadenas de texto. La segunda fecha siempre debe ser posterior a la primera, de lo contrario, se solicitará ingresar nuevamente ambas fechas en el formato correcto.

    * Especificaciones:

    *- El programa recibirá dos cadenas de texto en el formato "dd-MM-yyyy", representando las fechas a comparar.
    *- Si la segunda fecha es anterior a la primera, el programa solicitará ambas fechas de nuevo hasta que la segunda sea mayor que la primera.
    *- La función debe calcular la diferencia en días y retornar un valor entero (Int).
    *- Si alguna de las dos cadenas no representa una fecha válida en el formato correcto, el programa debe lanzar una excepción.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        formatoFecha.setLenient(false);

        Date fecha1 = null;
        Date fecha2 = null;

        while (true) {
            try {
                System.out.print("Ingrese la primera fecha (dd-MM-yyyy): ");
                fecha1 = formatoFecha.parse(scanner.nextLine());

                System.out.print("Ingrese la segunda fecha (dd-MM-yyyy): ");
                fecha2 = formatoFecha.parse(scanner.nextLine());

                if (fecha2.after(fecha1)) {
                    break;
                } else {
                    System.out.println("La segunda fecha debe ser mayor que la primera. Intente de nuevo.");
                }
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Intente de nuevo.");
            }
        }

        long diferenciaDias = (fecha2.getTime() - fecha1.getTime()) / (1000 * 60 * 60 * 24);
        System.out.println("Diferencia en días: " + diferenciaDias);
    }
}
