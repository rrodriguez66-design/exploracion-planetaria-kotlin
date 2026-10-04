fun main() {
    println("--- Misión de exploración planetaria ---\n")

    val exp1 = Explorador("Ares", 100)

    // 1. Probamos el desplazamiento (Fase 3.3)
    exp1.desplazarse(10.0)

    // 2. Probamos el setter personalizado (Fase 3.1)
    println("\n[Prueba] Intentando asignar 150% de energía...")
    exp1.energia = 150
    println("Resultado: La energía de ${exp1.nombre} quedó en ${exp1.energia}% (límite superado)")

    println("\n[Prueba] Intentando asignar -20% de energía...")
    exp1.energia = -20
    println("Resultado: La energía de ${exp1.nombre} quedó en ${exp1.energia}% (límite inferior)")

    // 3. Forzamos batería baja para probar la propiedad calculada
    exp1.energia = 15
    exp1.mostrarInformacion()
}