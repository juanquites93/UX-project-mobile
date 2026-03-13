# UX Project Mobile - Maquetación de Alarma Inteligente

Prototipo de alta fidelidad de una aplicación de alarma inteligente, desarrollado como proyecto para la materia de UX/Mejoramiento de experiencia de usuario. Es una maquetación navegable que simula el flujo completo de la aplicación.

## Flujo de pantallas

1. **Mis alarmas** — Lista de alarmas con estado del dispositivo
2. **Detalle de alarma** — Configuración y retos asignados
3. **Alarma activa** — Pantalla de desbloqueo
4. **Reto: Caminar** — Contador de pasos para desactivar
5. **Reto: Matemático** — Resolver ecuación con teclado numérico
6. **Reto: Escaneo QR** — Simula escaneo de objeto
7. **Tarea completada** — Confirmación animada entre retos
8. **Good Job** — Pantalla final de felicitación

## Nota importante para la navegación

En la pantalla del **Reto Matemático**, es necesario tocar el campo de respuesta para que aparezca el teclado numérico. Luego, ingresa cualquier valor numérico y oprime el botón de enviar (flecha) para avanzar a la siguiente pantalla.

## Diseño y maquetación

- Construido con **Jetpack Compose** y **Material Design 3**
- Paleta de colores personalizada (`AlarmColors`) con tonos oscuros/rosados
- Iconografía de **Material Icons Extended**
- Animaciones con `LoadingIndicator` (Material 3 Expressive)
- Navegación secuencial entre pantallas usando `Navigation Compose`
- Componentes reutilizables: `TagChip`, `SettingRow`, `ChallengePill`, `StatusCard`, `AlarmCard`

## Cómo ejecutar

### Opción 1: Instalar el APK directamente

1. Transfiere el archivo `app-release.apk` (incluido en la raíz del proyecto) a un dispositivo Android
2. Habilita la instalación de apps de orígenes desconocidos en Ajustes > Seguridad
3. Abre el APK e instálalo

### Opción 2: Compilar desde el código fuente

**Requisitos:** Android Studio Ladybug o superior, JDK 11+, Android SDK 36

```bash
git clone <url-del-repositorio>
```

1. Abre el proyecto en Android Studio
2. Espera a que Gradle sincronice las dependencias
3. Inicia un emulador android (API 31+)
4. Haz clic en **Run** 


