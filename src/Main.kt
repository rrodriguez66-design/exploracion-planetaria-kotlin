fun main() {
    println("--- Misión de exploración planetaria ---\n")

    // Instanciamos a los "hijos" específicos, ya no al Explorador abstracto
    val rover = RoverTerrestre("Ares", 100)
    val dron = DronExplorador("Ícaro", 100)

    // Probamos comportamientos sobrescritos
    rover.desplazarse(5.0)
    rover.explorar()

    println("--------------------------------------------------")

    // El dron gasta el doble de energía por km (10 * 5 = 50%)
    dron.desplazarse(5.0)
    dron.explorar()
    dron.mostrarInformacion()

    println("\n--- Pruebas de Transmisión (Interfaz) ---")
    rover.transmitirDatos("Hemos encontrado rocas con posible hielo.")
    dron.transmitirDatos("Mapeo del cuadrante norte completado sin anomalías.")

    println("\n--- Pruebas de Data Class y Enum (Fase 6) ---")
    // Usamos el Enum para la zona
    val hallazgo1 = Descubrimiento("Agua congelada", "Muestra de hielo en cráter", TipoZona.SEGURA)

    // Al imprimir, la data class genera un texto automático muy legible
    println("Descubrimiento original:")
    println(hallazgo1)

    // Usamos copy() para duplicar el hallazgo pero cambiarle algunos datos
    val hallazgo2 = hallazgo1.copy(
        descripcion = "Hielo contaminado con material orgánico",
        zona = TipoZona.PELIGROSA
    )

    println("\nDescubrimiento modificado con copy():")
    println(hallazgo2)
}