package com.example.masterrollerdice.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.masterrollerdice.modelo.HistorialEntrada

/**
 * Interfaz del dao de la tabla historial
 */
@Dao
interface HistorialDAO {
    /**
     * Operacion sobre la base de datos. Inserta un registro en la base de datos.
     */
    @Insert
    suspend fun insertar(historial: HistorialEntrada)

    /**
     * Operacion sobre la base de datos. Obtiene todos los registros de la base de datos.
     */
    @Query("SELECT * FROM historial")
    fun obtenerHistorial(): LiveData<List<HistorialEntrada>>

    /**
     * Operacion sobre la base de datos. Borra todos los registros de la base de datos.
     */
    @Query("DELETE FROM historial")
    suspend fun borrarHistorial()

    /**
     * Borra la secuencia de autoincremento
     */
    @Query("DELETE FROM sqlite_sequence WHERE name = 'historial'")
    suspend fun borrarSecuencia()


    /**
     * Operación sobre la fase de datos que añade los datos del csv a la base de datos
     */
    @Transaction
    suspend fun migrarCsvABd(listaHistorial: List<HistorialEntrada>) {
        for (fila in listaHistorial) {
            insertar(fila)
        }
    }
}