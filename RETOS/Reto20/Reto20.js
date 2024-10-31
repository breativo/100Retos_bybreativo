/*
    * Crea un programa que calcule y retorne cuántos días hay entre dos fechas dadas como cadenas de texto. La segunda fecha siempre debe ser posterior a la primera, de lo contrario, se solicitará ingresar nuevamente ambas fechas en el formato correcto.

    * Especificaciones:

    *- El programa recibirá dos cadenas de texto en el formato "dd-MM-yyyy", representando las fechas a comparar.
    *- Si la segunda fecha es anterior a la primera, el programa solicitará ambas fechas de nuevo hasta que la segunda sea mayor que la primera.
    *- La función debe calcular la diferencia en días y retornar un valor entero (Int).
    *- Si alguna de las dos cadenas no representa una fecha válida en el formato correcto, el programa debe lanzar una excepción.
     */
    
const readline = require("readline");
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

function parseDate(dateString) {
  const [day, month, year] = dateString.split("-");
  return new Date(`${year}-${month}-${day}`);
}

function isValidDate(dateString) {
  return /^\d{2}-\d{2}-\d{4}$/.test(dateString);
}

function calculateDaysDifference(date1, date2) {
  const diffInMs = Math.abs(date2 - date1);
  return Math.floor(diffInMs / (1000 * 60 * 60 * 24));
}

function askDates() {
  rl.question("Ingrese la primera fecha (dd-MM-yyyy): ", (inputDate1) => {
    if (!isValidDate(inputDate1)) {
      console.log("Formato de fecha incorrecto.");
      return askDates();
    }
    rl.question("Ingrese la segunda fecha (dd-MM-yyyy): ", (inputDate2) => {
      if (!isValidDate(inputDate2)) {
        console.log("Formato de fecha incorrecto.");
        return askDates();
      }

      const date1 = parseDate(inputDate1);
      const date2 = parseDate(inputDate2);

      if (date2 > date1) {
        const daysDifference = calculateDaysDifference(date1, date2);
        console.log(`Diferencia en días: ${daysDifference}`);
        rl.close();
      } else {
        console.log("La segunda fecha debe ser mayor que la primera.");
        askDates();
      }
    });
  });
}

askDates();
