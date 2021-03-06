# Room-Word-Sample

_Este repositorio contiene el código del codelab de **Componentes de la arquitectura de Android** en Java._

## Pre-requisitos 📋

- `Android Studio 4.2` o posterior.
- Android Studio actualizado, tanto el SDK y el Gradle.
- Un dispositivo o emulador que ejecute SDK nivel 19.

## Componentes de la app 📱

- `MainActivity`: muestra palabras en una lista usando un `RecyclerView`y el `WordListAdapter`. En `MainActivity` hay un `Observer` 
que observa las palabras LiveData de la base de datos y se notifica cuando cambian.
- `NewWordActivity`: agrega una nueva palabra a la lista.
- `WordViewModel`: proporciona métodos de acceso a la capa de datos y retorna LiveData para que `MainActivity` pueda configurar 
la relación del observador.
- `LiveData`: hace posible las actualizaciones automáticas en los componentes de la UI.
- `Repository`: gestiona una o más fuentes de datos. Expone métodos para que `ViewModel` interactúe con el proveedor de datos
subyacente. En esta app, ese backend es una base de datos Room.
- `Room`: es un contenedor e implementa una base de datos SQLite.
- `DAO`: asigna las llamadas al método a las consultas de la base de datos, de modo que cuando el Repository llama un método como
`getAlphabetizedWords()`, Room puede ejecutar `SELECT * FROM word_table ORDER BY word ASC`.
- `Word`: es la clase entidad que contiene una sola palabra.
- `Views` y `Activities` (y `Fragments`) solo interactúan con los datos mediante el `ViewModel`. Como tal, no importa de dónde
provengan los datos.

## Más información :link:

- **[Guía de arquitectura de apps](https://developer.android.com/jetpack/guide?hl=es)**
- **[Cómo guardar contenido en una base de datos local con Room](https://developer.android.com/training/data-storage/room)**
- **[Biblioteca de persistencias Room](https://developer.android.com/topic/libraries/architecture/room)**
- **[Jetpack - Room](https://developer.android.com/jetpack/androidx/releases/room)**
- **[Android Room with a View](https://developer.android.com/codelabs/android-room-with-a-view#0)**
