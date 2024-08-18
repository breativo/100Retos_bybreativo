package RETOS.Reto03;
/*
* Escribe un programa que imprima los 50 primeros números de la sucesión de Fibonacci empezando en 0.

    * - La serie Fibonacci se compone por una sucesión de números en la que el siguiente siempre es la suma de los dos anteriores.
    *  Ejemplo: 0, 1, 1, 2, 3, 5, 8, 13...
*/
public class Reto03 {
    
    public static void main(String[] args) {
        long a=0;
        long b=1;
        int numero=50;
        System.out.println(a);
        System.out.println(b);
        for (int i = 2; i < numero; i++) {
            long next= a+b;
            System.out.println(next);
            a = b;
            b = next;
        }
    }

}
