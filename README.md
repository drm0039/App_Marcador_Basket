# 🏀 App Marcador de Baloncesto 🏀

**Marcador de Baloncesto** es una aplicación nativa para Android desarrollada en Java que simula un marcador electrónico para partidos de baloncesto. La aplicación permite a los usuarios gestionar en tiempo real la puntuación de un equipo local y un equipo visitante, ofreciendo una interfaz de usuario limpia e intuitiva.

Este proyecto ha sido desarrollado como una demostración práctica de conceptos fundamentales y modernos del desarrollo de aplicaciones Android, incluyendo el uso de **Data Binding** para la gestión de la UI, la navegación explícita entre actividades y la implementación de una lógica de negocio encapsulada.

---

## 📜 Índice

1. [Descripción General](#descripción-general)
2. [🌟 Características Principales](#-características-principales)
3. [🛠️ Arquitectura y Tecnologías Utilizadas](#-arquitectura-y-tecnologías-utilizadas)

   * Componentes del Proyecto
   * Dependencias Clave
4. [⚙️ Análisis del Código Fuente](#-análisis-del-código-fuente)

   * Inicialización y Vinculación de Vistas
   * Gestión de Eventos (Listeners)
   * Lógica de Negocio
   * Navegación entre Actividades
5. [🚀 Cómo Compilar y Ejecutar el Proyecto](#-cómo-compilar-y-ejecutar-el-proyecto)
6. [💡 Posibles Mejoras y Futuras Funcionalidades](#-posibles-mejoras-y-futuras-funcionalidades)
7. [🖼️ Capturas de Pantalla](#-capturas-de-pantalla)
8. [✍️ Autor](#-autor)

---

## 📖 Descripción General

La aplicación presenta una pantalla principal (`MainActivity`) que funciona como el centro de control del marcador. En esta pantalla, se visualizan las puntuaciones de ambos equipos y se disponen de botones para manipular dichos valores.

**Acciones disponibles:**

* Añadir 1 punto (simulando un tiro libre).
* Añadir 2 puntos (simulando una canasta de campo).
* Restar 1 punto (para correcciones).
* Reiniciar el partido, estableciendo ambos marcadores a cero.
* Navegar a una pantalla de resultados (`ScoreActivity`) para ver un resumen final.

El proyecto está diseñado para ser **legible, mantenible y escalable**, aplicando buenas prácticas de desarrollo en Android.

---

## 🌟 Características Principales

* **Gestión de Puntuación Independiente:** Controla los marcadores del equipo local y visitante por separado.
* **Interfaz Reactiva con Data Binding:** La puntuación en la pantalla se actualiza instantáneamente gracias a Data Binding, eliminando la necesidad de `findViewById()` y `setText()`.
* **Validación de Datos:** Evita que los marcadores tomen valores negativos, mostrando un mensaje `Toast` al usuario.
* **Navegación Explícita:** Usa `Intent` para navegar desde la pantalla principal a la segunda actividad, pasando los resultados como extras.
* **Uso de Constantes para Claves:** Claves de extras definidas como `public static final String` para evitar errores de tipeo.
* **Estructura Organizada:** Métodos con responsabilidades únicas (`addPoints`, `subtract`, `reset`, `goToResults`) que mejoran la claridad y mantenimiento.

---

## 🛠️ Arquitectura y Tecnologías Utilizadas

Proyecto basado en una arquitectura simple **Activity-Vista** usando componentes de Android Jetpack.

### Componentes del Proyecto:

* **Lenguaje de Programación:** Java
* **Capa de Presentación (UI):**

  * XML Layouts para la interfaz.
  * Data Binding Library para vincular UI con lógica de la Activity.
  * LinearLayout y ConstraintLayout para disposición de elementos.
* **Componentes de Navegación:**

  * `Intent` explícito para iniciar `ScoreActivity`.
  * Paso de datos con `putExtra()` para enviar puntuaciones.
* **Componentes de Android Jetpack:**

  * `AppCompatActivity` para compatibilidad con versiones antiguas.
  * Material Components para botones y vistas modernas según Material Design.

### Dependencias Clave:

* `androidx.appcompat:appcompat`
* `com.google.android.material:material`
* `androidx.constraintlayout:constraintlayout`
* `dataBinding { enabled = true }`

---

## ⚙️ Análisis del Código Fuente (MainActivity.java)

### Inicialización y Vinculación de Vistas

```java
binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
```

* Infla el layout `activity_main.xml`.
* Crea `ActivityMainBinding` que contiene referencias a todas las vistas.

### Gestión de Eventos (Listeners)

```java
binding.btnLocalPlus1.setOnClickListener(v -> addPointsLocal(1));
```

* Cada botón llama a un método específico para encapsular la lógica.

### Lógica de Negocio

* Métodos como `addPointsLocal()`, `subtractPointVisitor()` y `resetScores()`:

  * Manipulan variables `scoreLocal` y `scoreVisitor`.
  * Actualizan la UI vía `binding.tvLocalScore.setText(String.valueOf(scoreLocal));`
  * Validan que los puntajes no sean negativos.

### Navegación entre Actividades

```java
private void goToResults() {
    Intent intent = new Intent(this, ScoreActivity.class);
    intent.putExtra(KEY_SCORE_LOCAL, scoreLocal);
    intent.putExtra(KEY_SCORE_VISITOR, scoreVisitor);
    startActivity(intent);
}
```

* Patrón de navegación explícita con datos empaquetados en `Intent`.

---

## 🚀 Cómo Compilar y Ejecutar el Proyecto

1. Clonar o descargar el proyecto:

   * Git: `git clone <URL_DEL_REPOSITORIO>`
   * O copiar los archivos localmente.
2. Abrir en Android Studio:

   * `File > Open...` > carpeta raíz del proyecto
   * Android Studio sincroniza Gradle y dependencias.
3. Ejecutar:

   * Usar un emulador o dispositivo físico con depuración USB
   * Seleccionar el dispositivo y hacer clic en `Run 'app'`

---

## 💡 Posibles Mejoras y Futuras Funcionalidades

1. Migrar lógica a **ViewModel** (arquitectura MVVM).
2. Usar **LiveData** para actualizar UI automáticamente.
3. Añadir **cronómetro del partido**.
4. Registrar **faltas por equipo**.
5. Persistir datos con **SharedPreferences** o **Room**.
6. Mejorar navegación con **Navigation Component**.
7. Diseño adaptable para distintos tamaños de pantalla.

---

## 🖼️ Capturas de Pantalla

|     Pantalla Principal del Marcador     |

<img width="249" height="533" alt="{8C1FA087-6B43-45A7-8891-F4813AE9CD66}" src="https://github.com/user-attachments/assets/0addea1d-cc62-44eb-bfd3-5d73a49ccdec" />
|      Pantalla de Resultados Finales      |
<img width="245" height="531" alt="{1BBB48C5-840E-4191-BE0A-F05C8E4AD0D0}" src="https://github.com/user-attachments/assets/084f96dc-1dcc-4133-87a3-1cccc844be09" />


---

## ✍️ Autor

* Daniel Rivera Miranda
* Contacto: drm0039@alu.medac.es
* GitHub: https://github.com/drm0039
