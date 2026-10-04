# Misión de Exploración Planetaria 🪐

## Descripción
Simulador en consola desarrollado en Kotlin que modela una misión científica de exploración planetaria. El sistema gestiona vehículos autónomos especializados (rovers terrestres y drones aéreos), evalúa su consumo energético, registra descubrimientos científicos a través de estructuras de datos y coordina las operaciones globales mediante un centro de control centralizado.

## Estructura del Proyecto
El código fuente está organizado modularmente en paquetes según sus responsabilidades:
- **`exploradores`**: Contiene la clase abstracta base `Explorador` y las implementaciones concretas `RoverTerrestre` y `DronExplorador`.
- **`modelo`**: Agrupa estructuras de datos, enumeraciones y contratos (`Descubrimiento`, `TipoZona`, `Comunicable`).
- **`control`**: Contiene el objeto singleton coordinador (`CentroControl`).
- **`utilidades`**: Alberga funciones de apoyo transversal (`Extensiones.kt`).
- **`src/Main.kt`**: Coordinador principal de la simulación.

## Ejecución
1. Clona el repositorio o abre el proyecto en **IntelliJ IDEA**.
2. Localiza el archivo `Main.kt` en la raíz de `src`.
3. Haz clic en el botón verde de reproducción (**Run**) ubicado junto a la función `main()` para iniciar la simulación en la consola.

---

## Conceptos Aplicados

| Concepto | ¿Dónde lo utilicé? | ¿Por qué lo utilicé? |
| :--- | :--- | :--- |
| **Constructor primario** | Clase `Explorador` y subclases. | Para inicializar las propiedades esenciales (`nombre`, `energia`, `distancia`) de forma directa y limpia al crear el objeto. |
| **Parámetros predeterminados** | En el constructor de `Explorador`. | Para evitar la sobrecarga de constructores, permitiendo omitir valores estándar como la energía inicial (100) o la distancia (0.0). |
| **init** | Bloque de inicialización en `Explorador`. | Para ejecutar validaciones y mensajes automáticos en el preciso instante en que el vehículo es instanciado. |
| **Getter personalizado** | Propiedad calculada `bateriaBaja`. | Para evaluar de manera dinámica si la energía es menor al 20% sin necesidad de almacenar ese estado booleano de forma estática. |
| **Setter personalizado** | Propiedad `energia` en `Explorador`. | Para aplicar una regla de encapsulación estricta que impide que la energía rebase los límites de 0 a 100%. |
| **Herencia** | Clases `RoverTerrestre` y `DronExplorador`. | Para heredar atributos y comportamientos comunes de la superclase `Explorador`, evitando la duplicación de código. |
| **Clase abstracta** | Clase base `Explorador`. | Para definir la plantilla genérica de un vehículo que no debe ser instanciado directamente por sí solo. |
| **open / override** | Funciones `desplazarse()` y `explorár()`. | `open` abre el método base en la superclase y `override` permite redefinirlo específicamente en los vehículos hijos. |
| **Interfaz** | Contrato `Comunicable`. | Para otorgar la capacidad transversal de transmisión de datos a distintos vehículos sin romper la jerarquía de herencia. |
| **data class** | Estructura `Descubrimiento`. | Para almacenar datos científicos generando automáticamente funciones útiles como `toString()` y `copy()`. |
| **enum class** | Tipo de terreno `TipoZona`. | Para restringir los estados posibles del terreno a un conjunto fijo y seguro de constantes (`SEGURA`, `ROCOSA`, `PELIGROSA`). |
| **Función de extensión** | `Double.comoDistancia()`. | Para añadir una capacidad de formato de texto directamente sobre tipos nativos (`Double`) sin modificar la clase original. |
| **object** | Singleton `CentroControl`. | Para asegurar que exista una única instancia global encargada de registrar la bitácora y los descubrimientos de toda la misión. |
| **companion object** | Variable `contadorExploradores`. | Para mantener un contador estático compartido a nivel de clase que rastrea el número total de vehículos fabricados. |
| **private / protected** | Propiedades internas de los vehículos. | Para proteger el estado interno (como `consumoBase` o el setter de `energia`), permitiendo su modificación exclusiva por la propia jerarquía. |
| **Paquetes** | Carpetas `exploradores`, `modelo`, `control`, `utilidades`. | Para mantener una arquitectura limpia, modular y coherente con las responsabilidades de cada componente. |

---

## Reflexión Final

1. **¿Qué diferencia existe entre una clase y un objeto?** La clase es el molde abstracto o plantilla conceptual, mientras que el objeto es la instancia física creada en la memoria a partir de ese molde, con un estado independiente.
2. **¿Qué diferencia encontraste entre val y var?** `val` define propiedades de solo lectura (inmutables), mientras que `var` permite reasignar nuevos valores a lo largo del tiempo (mutables).
3. **¿Qué ventaja ofrecen los parámetros predeterminados?** Reducen drásticamente la cantidad de código repetido al no requerir múltiples constructores sobrecargados.
4. **¿Para qué utilizaste init?** Para asegurar configuraciones y mensajes inmediatos al momento en que nace la instancia.
5. **¿Por qué utilizaste una clase abstracta para representar a los exploradores?** Porque agrupa la esencia común de los vehículos de la agencia pero obliga a que las instancias reales sean modelos concretos específicos.
6. **¿Qué comportamiento heredaron las subclases?** Las propiedades de identificación, la gestión de energía, el cálculo de distancia y los reportes base.
7. **¿Qué comportamiento sobrescribiste mediante override?** El consumo base específico (`consumoBase`), la forma de explorar (`explorár()`) y la manera de desplazarse.
8. **¿Qué representa la interfaz de tu programa?** Una capacidad o habilidad transversal (`Comunicable`) que distintos tipos de objetos pueden cumplir.
9. **¿Por qué esa capacidad se representó mediante una interfaz y no mediante herencia?** Porque Kotlin no permite herencia múltiple de clases; las interfaces permiten añadir habilidades de forma flexible.
10. **¿Qué ventaja tuvo utilizar una data class?** Proveer una estructura limpia para transportar información con métodos de utilidad listos para usarse como `copy()`.
11. **¿Qué ventaja tuvo utilizar una enum class?** Evitar errores de dedo y tipado al restringir valores a opciones constantes predefinidas.
12. **¿Qué hace la función de extensión que implementaste?** Extiende las capacidades de formato de los números decimales para imprimir distancias legibles con sufijos personalizados.
13. **¿Qué representa object CentroControl?** Una instancia única global (Singleton) encargada de coordinar las operaciones de la misión.
14. **¿Qué colocaste trong el companion object y por qué?** El contador global de exploradores, porque pertenece a la estadística de la clase y no a un vehículo individual.
15. **¿Cuál es la diferencia entre object y companion object en tu programa?** `object` representa un componente singleton independiente y global, mientras que el `companion object` está ligado internamente a una clase para compartir miembros estáticos.
16. **¿Qué información protegiste mediante modificadores de visibilidad?** El setter de la energía y las funciones internas de consumo para evitar manipulaciones externas indebidas desde el código principal.
17. **¿Cómo organizaste tu programa mediante paquetes?** Separando los componentes lógicos en carpetas (`exploradores`, `modelo`, `control`, `utilidades`) según su rol.
18. **Si tuvieras que agregar un nuevo tipo de explorador, ¿qué partes del programa tendrías que modificar?** Únicamente tendría que crear una nueva subclase heredando de `Explorador` y sobrecribiendo sus requerimientos abstractos, sin alterar el código de las demás clases existentes.