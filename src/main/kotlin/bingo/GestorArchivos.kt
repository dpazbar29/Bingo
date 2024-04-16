package bingo
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Object GestorArchivos
 * @constructor crea un registro de las simulaciones del bingo
 */
object GestorArchivos {
    private const val BINGO_DIR = ".bingo"
    private const val CONFIG_DIR = "config"
    private const val OUT_DIR = "out"
    private const val CONFIG = "bingo.conf"

    /**
     * Crea los directorios si no están ya creados
     */
    fun crearDirectorios() {
        val bingoDir = File(BINGO_DIR)
        val configDir = File("$BINGO_DIR/$CONFIG_DIR")
        val outDir = File("$BINGO_DIR/$OUT_DIR")

        if (!bingoDir.exists()) {
            bingoDir.mkdirs()
        }

        if (!configDir.exists()) {
            configDir.mkdirs()
        }

        if (!outDir.exists()) {
            outDir.mkdirs()
        }
    }

    /**
     * Crea el archivo configuración si no existe
     */
    fun crearConfigSiNoExiste() {
        val archivoConfig = File("$BINGO_DIR/$CONFIG_DIR/$CONFIG")
        if (!archivoConfig.exists()) {
            archivoConfig.createNewFile()
        }
    }

    /**
     * Crea el log de la simulación cada vez que es ejecutado el programa
     *
     * @return devuelve el fichero del log
     */
    fun crearArchivoLog(): File {
        val tiempoReal = LocalDateTime.now()
        val formateador = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
        val fechaFormateada = tiempoReal.format(formateador)
        val archivoLog = File("$BINGO_DIR/$OUT_DIR/$fechaFormateada.log")
        if (!archivoLog.exists()) {
            archivoLog.createNewFile()
        }
        return archivoLog
    }
}
