package com.example.masterrollerdice.modelView

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.application
import com.example.masterrollerdice.db.MasterRollerDice
import com.example.masterrollerdice.modelo.HistorialEntrada

class HistorialViewModel(
    application: Application,
) : AndroidViewModel(application) {
    fun obtenerHistorial(): LiveData<List<HistorialEntrada>> {
        val db = MasterRollerDice.getDatabase(application)
        return db.historialDao().obtenerHistorial()
    }
}
