// FASE 4.2: Clase abstracta
abstract class Explorador(
    val nombre: String,
    energiaInicial: Int = 100,
    var distancia: Double = 0.0
) {
    // Fase 4.4: protected permite que solo esta clase y sus subclases modifiquen el valor
    var energia: Int = energiaInicial
        protected set(valor) {
            field = when {
                valor > 100 -> 100
                valor < 0 -> 0
                else -> valor
            }
        }

    val bateriaBaja: Boolean
        get() = energia < 20

    // Propiedad abstracta: Cada vehículo hijo deberá definir cuánto consume
    abstract val consumoBase: Int

    init {
        this.energia = energiaInicial
    }

    protected fun consumirEnergia(cantidad: Int) {
        energia -= cantidad
    }

    // Función open: Permite que las subclases la sobrescriban (override) si lo necesitan
    open fun desplazarse(km: Double) {
        val energiaNecesaria = (km * consumoBase).toInt()
        if (energia >= energiaNecesaria) {
            distancia += km
            consumirEnergia(energiaNecesaria)
            println("[$nombre] Se desplazó $km km. Energía restante: $energia%")
        } else {
            println("[$nombre] ALERTA: Energía insuficiente para recorrer $km km.")
        }
    }

    // Función abstracta: Las subclases están obligadas a programar cómo exploran
    abstract fun explorar()

    open fun mostrarInformacion() {
        println("\n--- Reporte: $nombre ---")
        println("Distancia: $distancia km | Energía: $energia%")
    }
}