// FASE 4.3: Subclase Rover
class RoverTerrestre(nombre: String, energiaInicial: Int = 100) : Explorador(nombre, energiaInicial) {

    // Define su propio consumo
    override val consumoBase: Int = 5

    // Define cómo explora (obligatorio por ser abstracta en el padre)
    override fun explorar() {
        println("[$nombre] Rover terrestre analizando muestras geológicas del suelo...")
    }

    // FASE 4.4: Sobrescribe una función open del padre para darle un toque especial
    override fun desplazarse(km: Double) {
        println("\n[$nombre] Activando tracción de orugas para terreno marciano...")
        super.desplazarse(km) // Llama a la lógica original del padre
    }
}