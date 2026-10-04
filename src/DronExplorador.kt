// FASE 4.3: Subclase Dron
class DronExplorador(nombre: String, energiaInicial: Int = 100) : Explorador(nombre, energiaInicial) {

    // El dron gasta más energía por volar
    override val consumoBase: Int = 10

    override fun explorar() {
        println("[$nombre] Dron realizando escaneo aéreo y topográfico de la zona...")
    }

    override fun mostrarInformacion() {
        super.mostrarInformacion() // Muestra la info base
        println("Estado de rotores: ÓPTIMO") // Añade info exclusiva del dron
    }
}