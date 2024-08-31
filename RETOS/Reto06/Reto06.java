package RETOS.Reto06;

public class Reto06 {

/*
 * Crea una única función (importante que sólo sea una) que sea capaz de calcular y retornar el área de un polígono.
 * 
 * - La función recibirá por parámetro sólo UN polígono a la vez.
 * - Los polígonos soportados serán Triángulo, Cuadrado y Rectángulo.
 * - Imprime el cálculo del área de un polígono de cada tipo.
 */
 // Función para calcular el área de un polígono
public static double calcularArea(String tipo, double medida1, double medida2) {
    double area = 0.0;
    switch (tipo.toLowerCase()) {
        case "triangulo":
            area = 0.5 * medida1 * medida2; // medida1 es la base, medida2 es la altura
            break;
        case "cuadrado":
            area = medida1 * medida1; // medida1 es el lado
            break;
        case "rectangulo":
            area = medida1 * medida2; // medida1 es la base, medida2 es la altura
            break;
        default:
            throw new IllegalArgumentException("Tipo de polígono no soportado");
    }
    return area;
}

public static void main(String[] args) {
    // Imprimir el cálculo del área para cada tipo de polígono
    System.out.println("Área del triángulo: " + calcularArea("triangulo", 5, 10)); // base 5, altura 10
    System.out.println("Área del cuadrado: " + calcularArea("cuadrado", 4, 0)); // lado 4
    System.out.println("Área del rectángulo: " + calcularArea("rectangulo", 7, 3)); // base 7, altura 3
}
}
