package RETOS.Reto04;
/*
 * Escribe un programa que se encargue de comprobar si un número es o no primo.
 * Hecho esto, imprime los números primos entre 1 y 100.
 */
public class Reto04 {
    
    public static void main(String[] args) {
        System.out.println("Números primos entre 1 y 100:");
        for (int i = 0; i < 101; i++) {
            if(isPrimo(i)){
                System.out.println(i);
            }           
        }
    }

    public static boolean isPrimo(int numero){

        if(numero<=1){
            return false;
        }

        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if(numero % i == 0){
                return false;
            }
        }
        return true;
    }
}
