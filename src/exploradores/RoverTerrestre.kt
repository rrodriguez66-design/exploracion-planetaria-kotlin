package exploradores

class RoverTerrestre(nombre: String, energiaInicial: Int = 100) : Explorador(nombre, energiaInicial), Comunicable {

    override val consumoBase: Int = 5

    override fun explorar() {
        println("[$nombre] Rover terrestre analizando muestras geológicas del suelo...")
    }

    override fun desplazarse(km: Double) {
        println("\n[$nombre] Activando tracción de orugas para terreno marciano...")
        super.desplazarse(km)
    }

    // FASE 5.2: Implementación del contrato de la interfaz
    override fun transmitirDatos(mensaje: String) {
        println("[$nombre] 📡 Transmitiendo por antena parabólica terrestre: $mensaje")
    }
}