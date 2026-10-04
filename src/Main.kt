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
}