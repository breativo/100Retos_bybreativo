/*
 * Crea un programa que simule un evento deportivo de los Juegos Olímpicos,
 * donde el usuario puede crear un evento, agregar participantes, simular la
 * competencia y generar un informe con el resultado, incluyendo el podio y 
 * la clasificación por países.
 */

const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

class Evento {
  constructor(nombre) {
    this.nombre = nombre;
    this.participantes = [];
  }

  agregarParticipante(nombre, pais) {
    this.participantes.push({ nombre, pais });
  }

  simularEvento() {
    if (this.participantes.length < 3) {
      console.log("Debe haber al menos 3 participantes para simular el evento.");
      return null;
    }
    this.participantes.sort(() => Math.random() - 0.5);
    return this.participantes.slice(0, 3);
  }

  generarInforme(resultados) {
    console.log(`Simulación del evento '${this.nombre}':`);
    console.log(`🥇 Oro: ${resultados[0].nombre} (${resultados[0].pais})`);
    console.log(`🥈 Plata: ${resultados[1].nombre} (${resultados[1].pais})`);
    console.log(`🥉 Bronce: ${resultados[2].nombre} (${resultados[2].pais})`);
  }
}

const rankingPaises = {};

function mostrarMenu() {
  console.log("\nOpciones:");
  console.log("1. Nuevo evento");
  console.log("2. Salir");
  rl.question("Selecciona una opción: ", (opcion) => {
    if (opcion === "1") {
      rl.question("Ingresa el nombre del evento: ", (nombreEvento) => {
        const evento = new Evento(nombreEvento);

        function agregarParticipante() {
          rl.question("Ingresa el nombre del participante (o 0 para terminar): ", (nombreParticipante) => {
            if (nombreParticipante === "0") {
              if (evento.participantes.length > 0) {
                console.log("\nParticipantes registrados:");
                evento.participantes.forEach((p) => {
                  console.log(`- ${p.nombre} (${p.pais})`);
                });
              }
              return simularEvento();
            }
            rl.question("Ingresa el país del participante: ", (pais) => {
              evento.agregarParticipante(nombreParticipante, pais);
              agregarParticipante();
            });
          });
        }

        function simularEvento() {
          if (evento.participantes.length < 3) {
            console.log("Debe haber al menos 3 participantes para simular el evento.");
            return mostrarMenu();
          }
          const resultados = evento.simularEvento();
          if (resultados) {
            evento.generarInforme(resultados);
            resultados.forEach((participante, index) => {
              const pais = participante.pais;
              if (!rankingPaises[pais]) rankingPaises[pais] = [0, 0, 0];
              rankingPaises[pais][index]++;
            });
            console.log("\nRanking de países por medallas:");
            Object.entries(rankingPaises).forEach(([pais, medallas]) => {
              console.log(`${pais}: ${medallas[0]} Oro, ${medallas[1]} Plata, ${medallas[2]} Bronce`);
            });
          }
          mostrarMenu();
        }

        agregarParticipante();
      });
    } else if (opcion === "2") {
      console.log("¡Gracias por participar en los Juegos Olímpicos de París 2024!");
      rl.close();
    } else {
      mostrarMenu();
    }
  });
}

mostrarMenu();
