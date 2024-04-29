package bingo

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.versionOption
import com.github.ajalt.clikt.parameters.types.int
import de.m3y.kformat.Table
import de.m3y.kformat.table

class GestorFormato : CliktCommand() {
    private val formatoTabla by option("-f", "--formato", help = "Formato de salida: ts (Texto simple) o tt (Texto tabla)")
        .flag(default = false)

    private val ayuda by option("-h", "--ayuda", help = "Mostrar ayuda")
        .flag(default = false)

    private val numeroCarton by option("--carton", help = "Número de cartón de Bingo").int()

    init {
        versionOption("1.0.0")
    }

    override fun run() {
        if (ayuda) {
            printHelp()
            return
        }

        if (formatoTabla) {
            generarSalidaTabla(numeroCarton ?: 0)
        } else {
            generarSalidaTextoSimple(numeroCarton ?: 0)
        }
    }

    private fun generarSalidaTabla(numeroCarton: Int) {
        val cartonesEnJuego = mutableListOf<Carton>()
        val tablaFormato = tablaFormato(cartonesEnJuego, numeroCarton)
        println(tablaFormato)
    }

    private fun generarSalidaTextoSimple(numeroCarton: Int) {
        val cartonesEnJuego = mutableListOf<Carton>()
        cartonesEnJuego.forEachIndexed { index, carton ->
            println("Cartón ${index + 1}: ${carton.lineasTachadas} líneas tachadas")
        }
    }

    // Función para generar tabla de formato
    private fun tablaFormato(cartonesEnJuego: MutableList<Carton>, cartonBingo: Int): String {
        val tabla = table {
            header("Nº Cartón","Líneas","Bingo")

            var cont = 0
            var bingo: String

            while (cont < cartonesEnJuego.size){
                bingo = if (cartonBingo == cont) "Si" else "No"
                row((cont + 1).toString(),cartonesEnJuego[cont].lineasTachadas.toString(),bingo)
                cont++
            }

            hints {
                alignment("NºCartón", Table.Hints.Alignment.LEFT)
                borderStyle = Table.BorderStyle.SINGLE_LINE
            }
        }.render()

        return tabla.toString()
    }

    private fun printHelp(){
        println("Opciones bingoClikt: ")
        println()
        println("-f, --formato (ts: Texto Simple) o (tt: Texto Tabla)")
        println("-h, --help (Mostrar Ayuda)")
    }
}