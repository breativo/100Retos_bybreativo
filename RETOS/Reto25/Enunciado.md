# RETO #25: PARIS 2024
Dificultad: Difícil | Lenguajes: Python, Java, JavaScript y Kotlin.

## Enunciado

```
Crea un programa que simule un evento deportivo de los Juegos Olímpicos, donde el usuario puede crear un evento, agregar participantes, simular la competencia y generar un informe con el resultado, incluyendo el podio y la clasificación por países.

Requisitos del Programa:

- Crear un Evento:
        El programa permitirá al usuario crear un evento deportivo, donde el nombre del evento será ingresado por el propio usuario. Ejemplo: "100m planos", "Salto largo", "Natación", etc.
        El evento debe ser único, es decir, no se deben permitir eventos duplicados.

- Agregar Participantes:
        Una vez creado el evento, el usuario podrá agregar participantes, indicando su nombre y país.
        Número de Participantes: El usuario podrá agregar tantos participantes como desee, pero para poder simular el evento se requiere un mínimo de 3 participantes.
        Para detener la entrada de participantes, el usuario deberá escribir "0".
        Una vez que el usuario decide parar de ingresar participantes (escribiendo "0"), el programa mostrará la lista de participantes del evento.

- Simulación del Evento:
        Una vez que el evento tenga al menos tres participantes, el usuario podrá simular el evento.
        El programa asignará posiciones aleatorias a los participantes y mostrará el podio con las medallas asignadas:
            🥇 Oro al primer lugar.
            🥈 Plata al segundo lugar.
            🥉 Bronce al tercer lugar.

- Generar el Informe Final:
        El programa mostrará el informe con el podio del evento, indicando los medallistas (oro, plata y bronce).
        También generará un ranking de países basado en la cantidad de medallas obtenidas (oro, plata y bronce).

- Salida del programa:

1. Crear el Evento

Usuario: "Nuevo evento"
Programa:"Por favor, ingresa el nombre del evento:"
Usuario:"100m planos"
Programa:"Evento '100m planos' registrado con éxito."

2. Agregar Participantes

Programa:"Por favor, ingresa los participantes (nombre y país). Escribe '0' cuando hayas terminado."
Usuario:"Usain Bolt (Jamaica)"
Programa:"Participante 'Usain Bolt' registrado en '100m planos' con éxito."
Programa:"¿Quieres agregar más participantes? (Sí/No)"
Usuario:"Sí"
Programa:"Por favor, ingresa el nombre del siguiente participante."
Usuario:"Yohan Blake (Jamaica)"
Programa:"Participante 'Yohan Blake' registrado en '100m planos' con éxito."
Programa:"¿Quieres agregar más participantes? (Sí/No)"
Usuario:"Sí"
Programa:"Por favor, ingresa el nombre del siguiente participante."
Usuario:"Justin Gatlin (USA)"
Programa:"Participante 'Justin Gatlin' registrado en '100m planos' con éxito."
Programa:"¿Quieres agregar más participantes? (Sí/No)"
Usuario:"No"
Programa:"Registro de participantes detenido."
Programa:"Participantes en '100m planos':"

    Usain Bolt (Jamaica)
    Yohan Blake (Jamaica)
    Justin Gatlin (USA)

3. Simular el Evento

Usuario:"Simula el evento '100m planos'."
Programa:"Simulación del evento '100m planos':"

    🥇 Oro: Usain Bolt (Jamaica)
    🥈 Plata: Yohan Blake (Jamaica)
    🥉 Bronce: Justin Gatlin (USA)

4. Generar el Informe de Medallas

Usuario:"Genera el informe de medallas."
Programa:"Informe del evento '100m planos':"

    Usain Bolt (Jamaica) - 🥇 Oro
    Yohan Blake (Jamaica) - 🥈 Plata
    Justin Gatlin (USA) - 🥉 Bronce

Programa:
"Ranking de países por medallas:"

    Jamaica: 2 Oro, 1 Plata
    USA: 1 Bronce
   
```

## Respuestas y retos
Listado de los [100 retos](/README.md)

Soluciones al reto: 
[Java](/RETOS/Reto25/Reto25.java) | 
[JavaScript](/RETOS/Reto25/Reto25.js) | 
[Python](/RETOS/Reto25/Reto25.py) |
[Kotlin](/RETOS/Reto25/Reto25.kt)



## ¡Apóyame! 
#### Puedes apoyar mi trabajo haciendo "☆ Star" en el repositorio. ¡Gracias!

### En mi perfil de GitHub tienes más información

[![Web](https://img.shields.io/badge/GitHub-breativo-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://github.com/breativo)