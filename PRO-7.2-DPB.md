# **PREGUNTAS**
* **1.A** ¿Qué clases conoces para trabajar con ficheros?
* **1.B** ¿Pertenecen al conjunto de clases de Java, de java, pero extendidas en kotlin, de Koltin o son una librería externa?
* **1.C** ¿Qué posibilidades ofrecen estas clases?
* **2.A** ¿Qué clases y métodos has utilizado para solucionar el problema que se plantea?
* **2.B** ¿En qué parte del código la has utilizado?
* **2.C** ¿Cómo has hecho para independizar esta funcionalidad del resto del código?

# **RESPUESTAS**
### 1.A
Las principales clases que conozco para trabajar con archivos en Kotlin son File, Files, FileInputStream, y FileOutputStream.

### 1.B
Estas clases pertenecen al conjunto de clases de Java, pero al menos, la clase File, que es la que he seleccionado para este ejercicio ha de ser importada de la siguiente forma:

```Kotlin
import java.io.File
```
### 1.C
Estas clases ofrecen la posibilidad de [crear](https://github.com/dpazbar29/Bingo/blob/5da8d1aab3c1faa4dd86a607dd6f93a7f4f95df2/src/main/kotlin/bingo/GestorArchivos.kt#L19C5-L35C6), leer, escribir, copiar, mover y eliminar archivos y directorios.

### 2.A
En el problema planteado, he utilizado principalmente la clase File para manejar la creación y manipulación de directorios y archivos.

### 2.B
He utilizado estas clases en la implementación de la clase [GestorArchivos](https://github.com/dpazbar29/Bingo/blob/5da8d1aab3c1faa4dd86a607dd6f93a7f4f95df2/src/main/kotlin/bingo/GestorArchivos.kt#L10-L62), donde se definen métodos estáticos para configurar los directorios, crear archivos de configuración y crear archivos de registro.

### 2.C
Para independizar esta funcionalidad del resto del código, he encapsulado todas las operaciones relacionadas con archivos en la clase GestorArchivos, facilitando encontrar el código y utilizarlo con otros fines.