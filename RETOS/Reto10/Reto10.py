'''
    Crea un programa que simule el comportamiento del sombrero seleccionador del universo mágico de Harry Potter.

    - De ser posible realizará 5 preguntas (como mínimo) a través de la terminal.
    - Cada pregunta tendrá 4 respuestas posibles (también a selecciona una a través de terminal).
    - En función de las respuestas a las 5 preguntas deberás diseñar un algoritmo que coloque al alumno en una de las 4 casas de Hogwarts (Gryffindor, Slytherin , Hufflepuff y Ravenclaw)
    - Ten en cuenta los rasgos de cada casa para hacer las preguntas y crear el algoritmo seleccionador.

    Por ejemplo, en Slytherin se premia la ambición y la astucia.
'''
def main():
    gryffindor = 0
    slytherin = 0
    hufflepuff = 0
    ravenclaw = 0

    # Pregunta 1
    print("Pregunta 1: ¿Qué valoras más en un proyecto?")
    print("1) Coraje")
    print("2) Ambición")
    print("3) Lealtad")
    print("4) Intelecto")
    respuesta1 = input()

    if respuesta1 == "1":
        gryffindor += 1
    elif respuesta1 == "2":
        slytherin += 1
    elif respuesta1 == "3":
        hufflepuff += 1
    elif respuesta1 == "4":
        ravenclaw += 1

    # Pregunta 2
    print("Pregunta 2: ¿Qué prefieres?")
    print("1) Liderar")
    print("2) Manipular las reglas a tu favor")
    print("3) Ayudar a otros")
    print("4) Buscar el conocimiento")
    respuesta2 = input()

    if respuesta2 == "1":
        gryffindor += 1
    elif respuesta2 == "2":
        slytherin += 1
    elif respuesta2 == "3":
        hufflepuff += 1
    elif respuesta2 == "4":
        ravenclaw += 1

    # Pregunta 3
    print("Pregunta 3: ¿Cómo afrontas un problema?")
    print("1) Con valor, enfrentándolo directamente")
    print("2) Con astucia, buscando soluciones alternativas")
    print("3) Con paciencia, trabajando duro hasta resolverlo")
    print("4) Con análisis profundo, buscando aprender más sobre el problema")
    respuesta3 = input()

    if respuesta3 == "1":
        gryffindor += 1
    elif respuesta2 == "2":
        slytherin += 1
    elif respuesta2 == "3":
        hufflepuff += 1
    elif respuesta2 == "4":
        ravenclaw += 1

    # Pregunta 4
    print("Pregunta 4: ¿Cuál es tu entorno de trabajo ideal?")
    print("1) Un equipo unido y valiente")
    print("2) Un equipo competitivo y ambicioso")
    print("3) Un equipo colaborador y trabajador")
    print("4) Un equipo intelectual y creativo")
    respuesta4 = input()

    if respuesta4 == "1":
        gryffindor += 1
    elif respuesta2 == "2":
        slytherin += 1
    elif respuesta2 == "3":
        hufflepuff += 1
    elif respuesta2 == "4":
        ravenclaw += 1

    # Pregunta 5
    print("Pregunta 5: ¿Qué te motiva más en un proyecto?")
    print("1) El desafío y el coraje para enfrentarlo")
    print("2) El poder y el éxito que puedes obtener")
    print("3) El compromiso y la dedicación al equipo")
    print("4) El conocimiento y la oportunidad de aprender algo nuevo")
    respuesta5 = input()

    if respuesta5 == "1":
        gryffindor += 1
    elif respuesta2 == "2":
        slytherin += 1
    elif respuesta2 == "3":
        hufflepuff += 1
    elif respuesta2 == "4":
        ravenclaw += 1
    
    # Determinar casa
    if gryffindor >= slytherin and gryffindor >= hufflepuff and gryffindor >= ravenclaw:
        print("¡Has sido asignado a Gryffindor!")
    elif slytherin >= gryffindor and slytherin >= hufflepuff and slytherin >= ravenclaw:
        print("¡Has sido asignado a Slytherin!")
    elif hufflepuff >= gryffindor and hufflepuff >= slytherin and hufflepuff >= ravenclaw:
        print("¡Has sido asignado a Hufflepuff!")
    else:
        print("¡Has sido asignado a Ravenclaw!")

if __name__ == "__main__":
    main()
