'''
Crea un programa que sea capaz de transformar texto natural a código Morse y viceversa, detectando automáticamente el tipo de entrada (texto o Morse) y realizando la conversión correspondiente.
Especificaciones:

- Detección automática: El programa debe identificar si el texto de entrada está en lenguaje natural o en código Morse y seleccionar el modo de conversión adecuado.

- Formato de Código Morse:
        Usa el alfabeto Morse estándar. 
        Para representar letras o símbolos, se debe usar una raya (—), un punto (.), un espacio simple ( ) entre letras y símbolos y dos espacios ( ) entre palabras.
'''
morse_to_text = {
    ".-": "A", "-...": "B", "-.-.": "C", "-..": "D", ".": "E", "..-.": "F",
    "--.": "G", "....": "H", "..": "I", ".---": "J", "-.-": "K", ".-..": "L",
    "--": "M", "-.": "N", "---": "O", ".--.": "P", "--.-": "Q", ".-.": "R",
    "...": "S", "-": "T", "..-": "U", "...-": "V", ".--": "W", "-..-": "X",
    "-.--": "Y", "--..": "Z", "-----": "0", ".----": "1", "..---": "2",
    "...--": "3", "....-": "4", ".....": "5", "-....": "6", "--...": "7",
    "---..": "8", "----.": "9"
}
text_to_morse = {v: k for k, v in morse_to_text.items()}

def to_morse(text):
    return " ".join(text_to_morse.get(char, "") if char != " " else "" for char in text.upper())

def to_text(morse):
    return " ".join("".join(morse_to_text.get(symbol, "") for symbol in word.split()) for word in morse.split("  "))

input_text = input("Introduce el texto o código Morse: ")

if all(c in ".- " for c in input_text):
    print("Morse a Texto:", to_text(input_text))
else:
    print("Texto a Morse:", to_morse(input_text))
