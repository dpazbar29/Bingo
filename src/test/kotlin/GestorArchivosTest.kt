import bingo.GestorArchivos
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.File

class GestorArchivosTest : StringSpec({

    "debe crear la estructura de directorios si no existe" {
        val rootDir = File(".bingo")
        if (rootDir.exists()) {
            rootDir.deleteRecursively()
        }
        rootDir.exists() shouldBe false

        GestorArchivos.crearDirectorios()

        rootDir.exists() shouldBe true

        val configDir = File(".bingo/config")
        configDir.exists() shouldBe true

        val outDir = File(".bingo/out")
        outDir.exists() shouldBe true
    }

    "debe crear el archivo de configuración si no existe" {
        val archivoConfig = File(".bingo/config/bingo.conf")
        if (archivoConfig.exists()) {
            archivoConfig.delete()
        }
        archivoConfig.exists() shouldBe false

        GestorArchivos.crearConfigSiNoExiste()

        archivoConfig.exists() shouldBe true
    }

    "debe crear el archivo de log en el directorio correcto" {
        val logDir = File(".bingo/out")
        logDir.exists() shouldBe true

        val archivoLog = GestorArchivos.crearArchivoLog()

        archivoLog.exists() shouldBe true
        archivoLog.parentFile shouldBe logDir
    }
})
