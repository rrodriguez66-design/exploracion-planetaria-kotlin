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