class DronExplorador(nombre: String, energiaInicial: Int = 100) : Explorador(nombre, energiaInicial), Comunicable {

    override val consumoBase: Int = 10

    override fun explorar() {
        println("[$nombre] Dron realizando escaneo aéreo y topográfico de la zona...")
    }

    override fun mostrarInformacion() {
        super.mostrarInformacion()
        println("Estado de rotores: ÓPTIMO")
    }

    // FASE 5.2: Implementación del contrato de la interfaz
    override fun transmitirDatos(mensaje: String) {
        println("[$nombre] 🛰️ Transmitiendo vía satélite desde el aire: $mensaje")
    }
}