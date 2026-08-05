package com.example.masterrollerdice.utility

import android.content.Context
import androidx.navigation.NavController
import com.example.masterrollerdice.R
import com.example.masterrollerdice.modelo.HistorialEntrada
import kotlin.sequences.forEach

/**
 * Clase que procesa el fichero csv
 */
class GestionCSV {
    // Funcionan como estaticas de java
    companion object {
        /**
         * funcion encargada de leer el fichero csv
         */
        fun leerCSV(context: Context): List<HistorialEntrada> {
            val historialList = mutableListOf<HistorialEntrada>()
            try {
                // Leer desde almacenamiento interno, no desde assets
                context.openFileInput("historial.csv").bufferedReader().useLines { lines ->
                    lines.forEach { line ->
                        val columnas = line.split(',')
                        if (columnas.size >= 3) {
                            val entry =
                                HistorialEntrada(
                                    lanzamiento = columnas[0],
                                    tipoDado = columnas[1],
                                    total = columnas[2],
                                )
                            historialList.add(entry)
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return historialList
        }

        /**
         * Funcion que gestiona el borrado del hisotrial y del fichero csv
         */
        fun borrarHistorial(
            context: Context,
            navController: NavController,
        ) {
            context.deleteFile("historial.csv")
            navController.navigate(R.id.inicio)
        }
    }
}