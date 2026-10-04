class Explorador(
    val nombre: String,
    energiaInicial: Int = 100,
    var distancia: Double = 0.0
) {
    // FASE 3.4: Visibilidad (private). Esta tasa de consumo es interna y nadie de afuera debería alterarla.
    private val consumoPorKm: Int = 5

    // FASE 3.1: Setter personalizado. Impide que la energía baje de 0 o suba de 100.
    var energia: Int = energiaInicial
        set(valor) {
            field = when {
                valor > 100 -> 100
                valor < 0 -> 0
                else -> valor
            }
        }

    // FASE 3.2: Propiedad calculada (Getter personalizado). Se calcula en el momento, no almacena un dato estático.
    val bateriaBaja: Boolean
        get() = energia < 20

    init {
        // Aseguramos que la energía inicial pase por nuestro filtro del setter
        this.energia = energiaInicial
        println("Iniciando sistema del explorador: $nombre con $energia% de energía.")
    }

    // FASE 3.3: Funciones miembro y comportamiento
    private fun consumirEnergia(cantidad: Int) {
        energia -= cantidad
    }

    fun desplazarse(km: Double) {
        println("\n[$nombre] Iniciando desplazamiento de $km km...")
        val energiaNecesaria = (km * consumoPorKm).toInt()

        if (energia >= energiaNecesaria) {
            distancia += km
            consumirEnergia(energiaNecesaria) // Llamamos a la función privada
            println("[$nombre] Desplazamiento exitoso. Energía restante: $energia%")
        } else {
            println("[$nombre] ALERTA: Energía insuficiente para recorrer $km km.")
        }
    }

    fun mostrarInformacion() {
        println("\n--- Reporte de Misión: $nombre ---")
        println("Distancia total recorrida: $distancia km")
        println("Nivel de energía: $energia%")
        println("Batería crítica: ${if (bateriaBaja) "SÍ" else "NO"}")
    }
}