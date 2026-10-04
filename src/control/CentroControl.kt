package control

import modelo.Descubrimiento

// FASE 8.1: Centro de control mediante object (Singleton)
object CentroControl {
    private val registroOperaciones = mutableListOf<String>()
    var totalDescubrimientosRegistrados: Int = 0
        private set

    fun registrarOperacion(detalle: String) {
        registroOperaciones.add(detalle)
        println("🏢 [Centro de Control] Operación registrada: $detalle")
    }

    fun registrarDescubrimiento(descubrimiento: Descubrimiento) {
        totalDescubrimientosRegistrados++
        println("🔭 [Centro de Control] ¡Nuevo descubrimiento recibido! -> ${descubrimiento.tipo} (${descubrimiento.zona})")
    }

    fun mostrarResumenMisión() {
        println("\n==========================================")
        println("       INFORME GLOBAL DE LA MISIÓN        ")
        println("==========================================")
        println("Total de descubrimientos científicos: $totalDescubrimientosRegistrados")
        println("Total de operaciones en bitácora: ${registroOperaciones.size}")
        println("------------------------------------------")
    }
}