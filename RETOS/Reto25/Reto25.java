package RETOS.Reto25;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Crea un programa que simule un evento deportivo de los Juegos Olímpicos,
 * donde el usuario puede crear un evento, agregar participantes, simular la
 * competencia y generar un informe con el resultado, incluyendo el podio y 
 * la clasificación por países.
 */
class Participante {
    String nombre;
    String pais;

    Participante(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
    }
}

class Evento {
    String nombre;
    ArrayList<Participante> participantes;

    Evento(String nombre) {
        this.nombre = nombre;
        this.participantes = new ArrayList<>();
    }

    void agregarParticipante(String nombre, String pais) {
        participantes.add(new Participante(nombre, pais));
    }

    ArrayList<Participante> simularEvento() {
        if (participantes.size() < 3) {
            System.out.println("Debe haber al menos 3 participantes para simular el evento.");
            return null;
        }
        Collections.shuffle(participantes);
        return new ArrayList<>(participantes.subList(0, 3));
    }

    void generarInforme(ArrayList<Participante> resultados) {
        System.out.println("");
        System.out.println("Simulación del evento '" + nombre + "':");
        System.out.println("🥇 Oro: " + resultados.get(0).nombre + " (" + resultados.get(0).pais + ")");
        System.out.println("🥈 Plata: " + resultados.get(1).nombre + " (" + resultados.get(1).pais + ")");
        System.out.println("🥉 Bronce: " + resultados.get(2).nombre + " (" + resultados.get(2).pais + ")");
    }
}

public class Reto25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Evento> eventos = new ArrayList<>();
        Map<String, int[]> rankingPaises = new HashMap<>();

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Nuevo evento");
            System.out.println("2. Salir");
            String opcion = sc.nextLine();

            if (opcion.equals("1")) {
                System.out.print("Ingresa el nombre del evento: ");
                String nombreEvento = sc.nextLine();
                Evento evento = new Evento(nombreEvento);

                while (true) {
                    System.out.print("Ingresa el nombre del participante (o 0 para terminar): ");
                    String nombreParticipante = sc.nextLine();
                    if (nombreParticipante.equals("0")) {
                        if (!evento.participantes.isEmpty()) {
                            System.out.println("");
                            System.out.println("Participantes registrados:");
                            for (Participante p : evento.participantes) {
                                System.out.println("- " + p.nombre + " (" + p.pais + ")");
                            }
                        }
                        break;
                    }
                    System.out.print("Ingresa el país del participante: ");
                    String pais = sc.nextLine();
                    evento.agregarParticipante(nombreParticipante, pais);
                }

                if (evento.participantes.size() >= 3) {
                    ArrayList<Participante> resultados = evento.simularEvento();
                    if (resultados != null) {
                        evento.generarInforme(resultados);

                        for (int i = 0; i < 3; i++) {
                            String pais = resultados.get(i).pais;
                            rankingPaises.putIfAbsent(pais, new int[3]);
                            if (i == 0) {
                                rankingPaises.get(pais)[0]++;
                            } else if (i == 1) {
                                rankingPaises.get(pais)[1]++;
                            } else {
                                rankingPaises.get(pais)[2]++;
                            }
                        }
                        System.out.println("");
                        System.out.println("\nRanking de países por medallas:");
                        for (Map.Entry<String, int[]> entry : rankingPaises.entrySet()) {
                            String pais = entry.getKey();
                            int[] medallas = entry.getValue();
                            System.out.println(pais + ": " + medallas[0] + " Oro, " + medallas[1] + " Plata, " + medallas[2] + " Bronce");
                        }
                    }
                } else {
                    System.out.println("No hay suficientes participantes para simular el evento (se requieren al menos 3).");
                }
            } else if (opcion.equals("2")) {
                System.out.println("¡Gracias por participar en los Juegos Olímpicos de París 2024!");
                break;
            } else {
                System.out.println("Opción no válida.");
            }
        }
        sc.close();
    }
}
