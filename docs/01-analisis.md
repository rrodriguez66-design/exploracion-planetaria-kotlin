# Análisis del sistema

## Descripción del problema
**¿Qué sistema vas a representar?**
Un simulador de una misión científica de exploración planetaria.

**¿Qué elementos intervienen?**
Vehículos exploradores (rovers terrestres y drones), distintos tipos de zonas (seguras, rocosas, peligrosas), descubrimientos científicos y un centro de control de la misión.

**¿Qué información necesita conservar el sistema?**
El estado de los exploradores (nombre, nivel de energía, distancia recorrida), los datos de los descubrimientos realizados y el registro general de las operaciones en el centro de control.

**¿Qué operaciones deberá realizar?**
Desplazamiento de los vehículos (con su respectivo consumo de energía), análisis del terreno, registro de descubrimientos y coordinación desde el centro de control.

## Objetos y responsabilidades

| Objeto propuesto | Información que conserva | Comportamientos | Responsabilidad |
| :--- | :--- | :--- | :--- |
| **Explorador** | Nombre, energía (0-100%), distancia | Desplazarse, analizar, consumir energía | Recorrer el planeta y recolectar datos. |
| **Centro de Control** | Registros de misión y descubrimientos | Registrar operaciones, emitir resúmenes | Coordinar y almacenar el progreso general. |
| **Descubrimiento** | Tipo, descripción, zona | N/A (Es un contenedor de datos) | Representar un hallazgo científico. |
| **Zona** | Tipo (Segura, Rocosa, Peligrosa)| N/A (Es un estado o categoría) | Clasificar el terreno explorado. |

**¿Qué características tienen en común el rover y el dron?**
Ambos tienen un nombre, un nivel de energía, pueden desplazarse (aumentando su distancia y reduciendo su energía) y analizan zonas.

**¿Qué características son diferentes?**
El medio en el que se desplazan y la forma en que analizan. El rover opera en la superficie terrestre, mientras que el dron realiza vuelos de reconocimiento aéreo, lo que implicará consumos de energía y lógicas distintas.

**¿Existe un concepto más general que permita representar a ambos?**
Sí, el concepto general de "Vehículo Explorador" o simplemente "Explorador".

**¿Qué elementos parecen representar capacidades y no necesariamente tipos de objetos?**
La acción de "Analizar una zona" es una capacidad que distintos vehículos pueden ejecutar a su propia manera.

**¿Qué información pertenece a un explorador particular y cuál podría ser compartida?**
El nivel de energía, nombre y distancia pertenecen a un explorador particular. La bitácora general de la misión, los contadores globales y el registro de descubrimientos deben ser compartidos (Centro de control).

## Fase 2. Clases, objetos y constructores

**¿Qué diferencia existe entre la clase que definiste y los objetos que creaste a partir de ella?**
La clase `Explorador` es el "molde" o plantilla que define la estructura. Los objetos (`exp1`, `exp2`, `exp3`) son las instancias reales creadas en memoria a partir de ese molde, cada uno con sus propios datos.

**¿Por qué decidiste utilizar val o var para cada una de las propiedades principales de tu clase?**
Utilicé `val` para el `nombre` porque la identidad del explorador no debe cambiar una vez fabricado. Utilicé `var` para `energia` y `distancia` porque estos valores cambiarán constantemente mientras el vehículo se desplaza.

**¿Qué ventaja ofrecen los parámetros predeterminados?**
Permiten instanciar objetos con menos código y evitan tener que escribir múltiples constructores secundarios. Si al crear el objeto no especifico la distancia, Kotlin asume automáticamente el valor de 0.0.
 
**¿Cuándo se ejecuta el bloque init?**
Se ejecuta de forma automática e inmediata al momento de instanciar el objeto (justo después del constructor primario), siendo ideal para validaciones o mensajes iniciales de arranque.

## Fase 3. Propiedades, encapsulación y comportamiento

**¿Qué información protegiste mediante private?**
Protegí la propiedad `consumoPorKm` y la función `consumirEnergia()`.

**¿Por qué no debe modificarse directamente desde main()?**
Porque representan reglas internas del funcionamiento físico del vehículo. Si `main()` pudiera alterar la tasa de consumo, la simulación perdería fidelidad. `main()` solo debe ordenar el desplazamiento, y el objeto debe encargarse de calcular sus propios consumos internamente.

**¿Qué información necesita estar disponible para las subclases?**
(Esto se definirá en la siguiente fase), pero propiedades esenciales como `nombre`, `energia`, `distancia` y funciones base como `mostrarInformacion()` deberán ser accesibles o modificables por los vehículos específicos (rover y dron).

## Fase 4. Herencia y clases abstractas

### Diseño de la jerarquía
*   **Comunes:** Todos tienen nombre, energía, distancia, consumen batería y se desplazan.
*   **Diferencias:** El rover tiene tracción terrestre y consume menos energía. El dron vuela, escanea desde el aire y consume más energía.
*   **Exclusivas del dron:** Estado de rotores.
*   **Exclusivas del rover:** Tracción de orugas.

**¿Por qué Explorador es una clase abstracta?**
Porque el concepto "Explorador" es genérico. En la vida real de la misión no enviamos un "explorador" abstracto, enviamos un modelo físico concreto (un rover o un dron). La clase abstracta solo sirve como molde obligatorio.

**¿Qué heredaron RoverTerrestre y DronExplorador?**
Heredaron las propiedades (`nombre`, `energia`, `distancia`) y las funciones de control de batería (`desplazarse()`, `mostrarInformacion()`).

**¿Qué comportamiento sobrescribiste?**
Sobrescribí la propiedad abstracta `consumoBase`, la función abstracta `explorar()`, y las funciones abiertas (`open`) `desplazarse()` y `mostrarInformacion()`.

**¿Por qué fue necesario utilizar open y override?**
Porque la herencia por defecto en Kotlin está bloqueada (las clases son `final`). Usar `open` en el padre permite abrir el candado, y usar `override` en el hijo indica explícitamente que estamos modificando ese comportamiento heredado para adaptarlo a ese vehículo.

## Fase 5. Interfaces

**¿Qué capacidad representa tu interfaz?**
Representa la capacidad de comunicación (`Comunicable`), específicamente enviar transmisiones o mensajes de datos.

**¿Qué clases la implementan?**
Tanto `RoverTerrestre` como `DronExplorador`.

**¿Por qué utilizaste una interfaz en lugar de otra superclase?**
Porque Kotlin no permite la herencia múltiple (un vehículo no puede heredar de dos clases abstractas al mismo tiempo). Las interfaces permiten agregar capacidades extra a una clase sin romper su jerarquía principal.

**¿Qué diferencia existe entre lo que representa Explorador y lo que representa tu interfaz?**
La clase abstracta `Explorador` define la *esencia* y el estado base del objeto (tiene energía, tiene nombre). La interfaz `Comunicable` define simplemente un *contrato de comportamiento* o habilidad que el objeto es capaz de realizar (puede transmitir).

## Fase 6. Recursos específicos de Kotlin

**¿Qué ventaja ofrece utilizar TipoZona en lugar de representar estos estados mediante String?**
Previene errores de escritura (typos) y restringe las opciones. Si usara un String, alguien podría escribir "peligrosa", "Peligrosa" o "Peligro", causando errores. Con el `enum class`, el compilador solo acepta las 3 opciones estrictas que definí.

**¿Por qué Descubrimiento es un buen candidato para una data class?**
Porque su única responsabilidad es almacenar y transportar datos (tipo, descripción y zona). No necesita lógica compleja ni modificar comportamientos.

**¿Qué comportamiento proporciona Kotlin automáticamente?**
Kotlin genera automáticamente funciones muy útiles por detrás, como `toString()` (para imprimir el objeto de forma legible en texto), `equals()` (para comparar si dos objetos tienen los mismos datos) y `hashCode()`.

**¿Qué hace copy()?**
Permite crear un clon exacto de un objeto existente, dándote la opción de modificar solamente propiedades específicas en el nuevo objeto, manteniendo el original intacto (ideal para trabajar con variables inmutables `val`).

## Fase 7. Funciones de extensión

**¿Qué tipo extendiste?**
Extendí el tipo nativo `Double` de Kotlin.

**¿Qué funcionalidad agregaste?**
Agregué la función `comoDistancia()`, la cual formatea automáticamente cualquier número decimal agregándole el sufijo " km", devolviendo un String listo para la interfaz.

**¿Modificaste realmente la clase original?**
No, la clase original `Double` de Kotlin permanece intacta. La función de extensión se resuelve de forma estática, simplemente "simulando" ser parte de la clase para facilitar su uso en este proyecto.

**¿Puede la extensión acceder directamente a los miembros private de esa clase?**
No, las funciones de extensión respetan la encapsulación. Solo tienen acceso a los miembros públicos (`public`) de la clase que extienden.