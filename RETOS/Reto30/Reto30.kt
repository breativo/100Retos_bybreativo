fun encriptarMensaje(mensaje: String, clave: Int): String {
    val mensajeEncriptado = StringBuilder()
    var claveMod = clave % 26 

    for (caracter in mensaje) {
        if (caracter.isLetter()) {
            val base = if (caracter.isLowerCase()) 'a' else 'A'
            val nuevoCaracter = (base + (caracter - base + claveMod) % 26)
            mensajeEncriptado.append(nuevoCaracter)
        } else {
            mensajeEncriptado.append(caracter)
        }
    }
    return mensajeEncriptado.toString()
}

fun main() {

    println("Introduce el mensaje: ")
    val mensaje = readLine() ?: ""
    println("Introduce la clave: ")
    val clave = readLine()?.toIntOrNull() ?: 0
    val mensajeEncriptado = encriptarMensaje(mensaje, clave)
    println("Mensaje encriptado: $mensajeEncriptado")
}
