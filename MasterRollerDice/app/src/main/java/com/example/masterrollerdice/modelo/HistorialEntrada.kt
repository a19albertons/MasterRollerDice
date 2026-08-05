package com.example.masterrollerdice.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class interno que procesa el fichero csv
 */
@Entity(tableName = "historial")
data class HistorialEntrada (
    @PrimaryKey(autoGenerate = true)
    val lanzamiento: Int,
    val tipoDado: String,
    val total: Int,
)
