'''
Crea un programa que simule un evento deportivo de los Juegos Olímpicos,
donde el usuario puede crear un evento, agregar participantes, simular la
competencia y generar un informe con el resultado, incluyendo el podio y 
la clasificación por países.
'''

import random

class Evento:
    def __init__(self, nombre):
        self.nombre = nombre
        self.participantes = []

    def agregar_participante(self, nombre, pais):
        self.participantes.append({"nombre": nombre, "pais": pais})

    def simular_evento(self):
        if len(self.participantes) < 3:
            print("Debe haber al menos 3 participantes para simular el evento.")
            return None
        random.shuffle(self.participantes)
        resultados = self.participantes[:3]
        return resultados

    def generar_informe(self, resultados):
        print(f"\nSimulación del evento '{self.nombre}':")
        print(f"🥇 Oro: {resultados[0]['nombre']} ({resultados[0]['pais']})")
        print(f"🥈 Plata: {resultados[1]['nombre']} ({resultados[1]['pais']})")
        print(f"🥉 Bronce: {resultados[2]['nombre']} ({resultados[2]['pais']})")


def main():
    eventos = []
    ranking_paises = {}

    while True:
        print("\nOpciones:")
        print("1. Nuevo evento")
        print("2. Salir")
        opcion = input("Selecciona una opción: ")

        if opcion == "1":
            nombre_evento = input("Ingresa el nombre del evento: ")
            evento = Evento(nombre_evento)

            while True:
                nombre_participante = input("Ingresa el nombre del participante (o 0 para terminar): ")
                if nombre_participante == "0":
                    if evento.participantes:
                        print("\nParticipantes registrados:")
                        for p in evento.participantes:
                            print(f"- {p['nombre']} ({p['pais']})")
                    break
                pais = input("Ingresa el país del participante: ")
                evento.agregar_participante(nombre_participante, pais)

            if len(evento.participantes) >= 3:
                resultados = evento.simular_evento()
                if resultados:
                    evento.generar_informe(resultados)

                    for i in range(3):
                        pais = resultados[i]['pais']
                        if pais not in ranking_paises:
                            ranking_paises[pais] = [0, 0, 0]
                        if i == 0:
                            ranking_paises[pais][0] += 1
                        elif i == 1:
                            ranking_paises[pais][1] += 1
                        else:
                            ranking_paises[pais][2] += 1

                    print("\nRanking de países por medallas:")
                    for pais, medallas in ranking_paises.items():
                        print(f"{pais}: {medallas[0]} Oro, {medallas[1]} Plata, {medallas[2]} Bronce")
            else:
                print("No hay suficientes participantes para simular el evento (se requieren al menos 3).")

        elif opcion == "2":
            print("¡Gracias por participar en los Juegos Olímpicos de París 2024!")
            break
        else:
            print("Opción no válida")


if __name__ == "__main__":
    main()
