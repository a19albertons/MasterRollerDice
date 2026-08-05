package com.example.masterrollerdice.adaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.masterrollerdice.R
import com.example.masterrollerdice.modelo.HistorialEntrada

/**
 * El adapter que genera la lista dinamica a partir del contenido del csv
 */
class HistorialAdapter(
    private var historialList: MutableList<HistorialEntrada>,
) : RecyclerView.Adapter<HistorialAdapter.HistorialViewHolder>() {
    /**
     * Clase interna que representa una fila de la lista
     */
    class HistorialViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {
        val historialLanzamientol: TextView = itemView.findViewById(R.id.historial_lanzamiento)
        val historialTipoDado: TextView = itemView.findViewById(R.id.historial_tipo_dado)
        val historialTotal: TextView = itemView.findViewById(R.id.historial_total)
    }

    /**
     * Crea una nueva vista (fila)
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HistorialViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.historial_objetos, parent, false)
        return HistorialViewHolder(view)
    }

    /**
     * Reemplaza el contenido de una vista (une los datos a la vista)
     */
    override fun onBindViewHolder(
        holder: HistorialViewHolder,
        position: Int,
    ) {
        val currentItem = historialList[position]
        holder.historialLanzamientol.text = currentItem.lanzamiento
        holder.historialTipoDado.text = currentItem.tipoDado
        holder.historialTotal.text = currentItem.total
    }

    /**
     * Devuelve el número de elementos en la lista
     */
    override fun getItemCount() = historialList.size

    /**
     * Borra todos los datos de la lista
     */
    fun limpiarDatos() {
        historialList.clear() // Borra la lista en memoria
        notifyDataSetChanged() // Avisa al RecyclerView para que se repinte
    }
}