package com.example.masterrollerdice.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
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
    fun insertar(historial: HistorialEntrada)

    /**
     * Operacion sobre la base de datos. Obtiene todos los registros de la base de datos.
     */
    @Query("SELECT * FROM historial")
    fun obtenerHistorial(): List<HistorialEntrada>

    /**
     * Operacion sobre la base de datos. Borra todos los registros de la base de datos.
     */
    @Query("DELETE FROM historial")
    fun borrarHistorial()

}