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