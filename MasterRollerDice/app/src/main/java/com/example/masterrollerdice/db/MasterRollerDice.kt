package com.example.masterrollerdice.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.masterrollerdice.dao.HistorialDAO
import com.example.masterrollerdice.modelo.HistorialEntrada

@Database(entities = [HistorialEntrada::class], version = 1)
abstract class MasterRollerDice : RoomDatabase() {
    /**
     * Contiene el dao de la tabla historial
     */
    abstract fun historialDao(): HistorialDAO

    companion object {
        /**
         * Instancia de la base de datos
         */
        @Volatile
        private var instanciaDB: MasterRollerDice? = null

        /**
         * Devuelve la instancia de la base de datos
         */
        fun getDatabase(context: Context): MasterRollerDice =
            instanciaDB ?: synchronized(this) {
                val instance =
                    Room
                        .databaseBuilder(
                            context.applicationContext,
                            MasterRollerDice::class.java,
                            "baseDatos.db",
                        )
                        // La construye
                        .build()

                // genera la instancia singleston
                instanciaDB = instance

                // valor a devolver que requiere synchronized
                instance
            }
    }
}
