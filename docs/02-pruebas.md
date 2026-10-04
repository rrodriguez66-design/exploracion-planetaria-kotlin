# Evidencias de Pruebas del Sistema

A continuación se documentan las pruebas realizadas durante el desarrollo de la misión de exploración planetaria, incluyendo los resultados esperados y obtenidos, junto con las evidencias de ejecución.

## Pruebas de la Fase 2: Clases y Constructores
*   **Prueba:** Crear dos exploradores.
*   **Resultado esperado:** Cada objeto conserva su propio estado independiente.
*   **Resultado obtenido:** ¡Exitoso! Se crearon `Ares` e `Ícaro` y cada uno mostró sus datos iniciales sin interferir con el otro.
*   **Evidencia:**
    ```text
    Ares ha recorrido 5.5 km y tiene 90% de energía.
    Ícaro ha recorrido 0.0 km y tiene 100% de energía.
    ```

*   **Prueba:** Utilizar un parámetro predeterminado.
*   **Resultado esperado:** Se utiliza correctamente el valor establecido.
*   **Resultado obtenido:** ¡Exitoso! El objeto `Ícaro` inicializó su distancia en 0.0 km sin necesidad de enviarle el argumento.

## Pruebas de la Fase 3: Encapsulación
*   **Prueba:** Asignar energía mayor a 100.
*   **Resultado esperado:** No se conserva un valor inválido (se limita a 100).
*   **Resultado obtenido:** ¡Exitoso! Al intentar asignar 150 a Ares, el sistema lo ajustó a 100.
*   **Evidencia:**
    ```text
    [Prueba] Intentando asignar 150% de energía...
    Resultado: La energía de Ares quedó en 100% (límite superado)
    ```

    <img width="1537" height="562" alt="image" src="https://github.com/user-attachments/assets/2dc57cbd-c3b3-48eb-b917-0eeff33c3fb5" />


*   **Prueba:** Asignar energía menor a 0.
*   **Resultado esperado:** No se conserva un valor inválido (se limita a 0).
*   **Resultado obtenido:** ¡Exitoso! Al intentar asignar -20 a Ares, el sistema lo ajustó a 0.

---
*(Las siguientes pruebas se irán documentando conforme se completen las Fases 4 a la 10)*


## Pruebas de la Fase 4: Herencia
*   **Prueba:** Crear un rover y un dron y ejecutar comportamiento sobrescrito.
*   **Resultado esperado:** Cada tipo responde de acuerdo con su implementación (heredan lo común, pero exploran y se desplazan distinto).
*   **Resultado obtenido:** ¡Exitoso! El dron gastó 50% de energía al recorrer 5km, mientras que el rover gastó solo 25% por la misma distancia gracias al polimorfismo de `consumoBase`. Además, imprimieron mensajes distintos al explorar.
<img width="1723" height="956" alt="image" src="https://github.com/user-attachments/assets/4b4d8c6b-7ece-465f-baa6-4e30b2e164ff" />


## Pruebas de la Fase 5: Interfaces
*   **Prueba:** Utilizar la interfaz en diferentes objetos.
*   **Resultado esperado:** Las clases correspondientes cumplen el contrato definido en `Comunicable`.
*   **Resultado obtenido:** ¡Exitoso! Al llamar a `transmitirDatos()`, tanto el rover como el dron enviaron su mensaje, pero cada uno con su propio estilo (antena terrestre vs vía satélite).

<img width="1666" height="770" alt="image" src="https://github.com/user-attachments/assets/daae6dce-9f4c-4205-90e8-35089163a98e" />

## Pruebas de la Fase 6: Enum y Data Class
*   **Prueba:** Utilizar `modelo.TipoZona.SEGURA` o `ROCOSA`.
*   **Resultado esperado:** Se utiliza correctamente el enum.
*   **Resultado obtenido:** ¡Exitoso! Se asignó `modelo.TipoZona.SEGURA` y `modelo.TipoZona.PELIGROSA` a los hallazgos sin errores de tipo.

*   **Prueba:** Crear un descubrimiento e imprimirlo.
*   **Resultado esperado:** La data class conserva sus datos y los imprime automáticamente con buen formato.
*   **Resultado obtenido:** ¡Exitoso! La consola imprimió la estructura `Descubrimiento(tipo=..., descripcion=..., zona=...)`.

*   **Prueba:** Utilizar `copy()`.
*   **Resultado esperado:** Se obtiene un nuevo objeto con la modificación solicitada.
*   **Resultado obtenido:** ¡Exitoso! Se duplicó el hallazgo 1 para crear el hallazgo 2, cambiando solo la descripción y la zona, dejando el tipo intacto.



<img width="1637" height="802" alt="image" src="https://github.com/user-attachments/assets/3e672c71-9c32-4084-9096-b38b353cf2c1" />

## Pruebas de la Fase 7: Función de extensión
*   **Prueba:** Ejecutar la función de extensión `comoDistancia()` sobre un tipo Double.
*   **Resultado esperado:** Produce el resultado esperado formateando el valor numérico.
*   **Resultado obtenido:** ¡Exitoso! Al aplicar la función sobre `45.5`, la consola imprimió el texto "45.5 km".

<img width="1536" height="717" alt="image" src="https://github.com/user-attachments/assets/e228f0d7-5372-4204-9475-38ef358a240c" />


## Pruebas de la Fase 8: Object y Companion Object
*   **Prueba:** Utilizar `CentroControl` desde diferentes puntos sin instanciarlo.
*   **Resultado esperado:** Se utiliza exactamente el mismo objeto global para registrar y mostrar datos.
*   **Resultado obtenido:** ¡Exitoso! El centro de control acumuló las operaciones y descubrimientos correctamente.

*   **Prueba:** Crear varios exploradores y verificar el contador global.
*   **Resultado esperado:** El elemento del `companion object` se comparte y contabiliza correctamente a todas las instancias.
*   **Resultado obtenido:** ¡Exitoso! Al invocar `exploradores.Explorador.contadorExploradores`, devolvió el número exacto de vehículos creados.

  <img width="1672" height="867" alt="image" src="https://github.com/user-attachments/assets/44a64040-82a7-4d01-9a72-f3b8e83c9890" />


## Pruebas de la Fase 9: Paquetes e Integración
*   **Prueba:** Compilación y ejecución tras reorganizar las clases en paquetes.
*   **Resultado esperado:** El proyecto compila sin errores de importación y el archivo `Main.kt` coordina correctamente los paquetes mediante sentencias `import`.
*   **Resultado obtenido:** ¡Exitoso! El sistema mantiene exactamente el mismo comportamiento funcional pero con una arquitectura modular y limpia.

<img width="1715" height="948" alt="image" src="https://github.com/user-attachments/assets/c89c00e2-efc8-4633-ab33-fbd8040be22d" />
