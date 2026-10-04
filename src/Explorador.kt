class Explorador(
    val nombre: String,
    var energia: Int = 100,        // Parámetro con valor predeterminado
    var distancia: Double = 0.0    // Parámetro con valor predeterminado
) {
    // El bloque init se ejecuta inmediatamente al nacer el objeto
    init {
        println("Iniciando sistema del explorador: $nombre con $energia% de energía inicial.")
    }
}