package com.example.masterrollerdice.adaper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.masterrollerdice.R
import com.example.masterrollerdice.modelo.HistorialEntrada

/**
 * El adapter que genera la lista dinamica a partir del contenido del csv
 */
class HistorialAdapter : ListAdapter<HistorialEntrada, HistorialAdapter.HistorialViewHolder>(
    HistorialEntradaComprobacionDiferencias()
) {
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
        val currentItem = getItem(position)
        holder.historialLanzamientol.text = currentItem.lanzamiento.toString()
        holder.historialTipoDado.text = currentItem.tipoDado
        holder.historialTotal.text = currentItem.total.toString()
    }

    class HistorialEntradaComprobacionDiferencias : DiffUtil.ItemCallback<HistorialEntrada>() {
        override fun areItemsTheSame(
            oldItem: HistorialEntrada,
            newItem: HistorialEntrada
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: HistorialEntrada,
            newItem: HistorialEntrada
        ): Boolean {
            return oldItem.lanzamiento == newItem.lanzamiento
        }


    }
}