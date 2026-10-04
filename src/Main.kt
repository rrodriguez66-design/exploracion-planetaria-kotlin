fun main() {
    println("--- Misión de exploración planetaria ---\n")

    // Creando instancias de diferentes formas
    val exp1 = Explorador("Ares", 100, 0.0) // Proporcionando todos los argumentos
    val exp2 = Explorador("Ícaro") // Utilizando los valores predeterminados
    val exp3 = Explorador(nombre = "Odiseo", energia = 80) // Utilizando argumentos con nombre

    println("\n--- Operaciones ---")
    // Experimentando con var (se puede modificar)
    exp1.energia = 90
    exp1.distancia = 5.5

    // Experimentando con val (Si quitas las diagonales, IntelliJ marcará error porque 'val' no se puede reasignar)
    // exp1.nombre = "Nuevo Nombre"

    println("${exp1.nombre} ha recorrido ${exp1.distancia} km y tiene ${exp1.energia}% de energía.")
    println("${exp2.nombre} ha recorrido ${exp2.distancia} km y tiene ${exp2.energia}% de energía.")
}