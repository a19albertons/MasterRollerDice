package com.example.masterrollerdice.utility

import android.content.Context
import android.util.Log
import com.example.masterrollerdice.db.MasterRollerDice
import com.example.masterrollerdice.modelo.HistorialEntrada
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import kotlin.sequences.forEach

/**
 * Clase que procesa el fichero csv
 */
class GestionCSV {
    // Funcionan como estaticas de java
    companion object {
        private val FILENAME = "historial.csv"

        /**
         * funcion encargada de leer el fichero csv
         */
        fun leerCSV(context: Context): List<HistorialEntrada> {
            var historialList = mutableListOf<HistorialEntrada>()
            try {
                // Leer desde almacenamiento interno, no desde assets
                context.openFileInput("historial.csv").bufferedReader().useLines { lines ->
                    lines.forEach { line ->
                        val columnas = line.split(',')
                        if (columnas.size >= 3) {
                            val entry =
                                HistorialEntrada(
                                    lanzamiento = columnas[0].toInt(),
                                    tipoDado = columnas[1],
                                    total = columnas[2].toInt(),
                                )
                            historialList.add(entry)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                historialList = mutableListOf()
            }
            return historialList
        }

        /**
         * Funcion que gestiona el borrado del hisotrial y del fichero csv
         */
        fun borrarHistorial(context: Context) {
            context.deleteFile("historial.csv")
        }

        suspend fun migrarCsvABd(context: Context) {
            try {
                val file = File(context.filesDir, "historial.csv")
                if (file.exists()) {
                    val listaHistorial = leerCSV(context)

                    // Migra el historial
                    val db = MasterRollerDice.getDatabase(context)
                    db.historialDao().migrarCsvABd(listaHistorial)

                    // Borra el historial del csv
                    borrarHistorial(context)
                } else {
                    Log.d("migracion", "No hay datos que migrar o fallo en la función")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("Error", "Algo ha fallado durante la migración final")
            }
        }

        fun anadirFila(
            context: Context,
            fila: HistorialEntrada,
            dataAEscribir: String,
        ) {
            try {
                // Usa openFileOutput para escribir en el almacenamiento interno de la app.
                // MODE_APPEND es crucial: añade al final en lugar de sobrescribir.
                val outputStream: FileOutputStream = context.openFileOutput(FILENAME, Context.MODE_APPEND)

                // Escribe la cadena al archivo.
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(dataAEscribir)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Manejar el error de escritura (ej. almacenamiento lleno)
            }
        }
    }
}
