package com.example.masterrollerdice.fragmentos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.masterrollerdice.R
import com.example.masterrollerdice.adaper.HistorialAdapter
import com.example.masterrollerdice.db.MasterRollerDice
import com.example.masterrollerdice.modelView.HistorialViewModel

/**
 * Fragmento del historial
 */
class Historial : Fragment() {
    val model: HistorialViewModel by viewModels()

    /**
     * Crea la vista del fragmento
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_historial, container, false)

        // Comprobamos si el csv esta vacio o no
        val vacio = view.findViewById<LinearLayout>(R.id.no_hay_contenido_historial)
        val contenido = view.findViewById<LinearLayout>(R.id.hay_contenido_historial)

        // 1. Obtén la lista de datos del CSV
        val db = MasterRollerDice.getDatabase(requireContext())

        // 2. Obtén la referencia al RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.historial_recycler_view)

        // 3. Configura el RecyclerView
        // Un LayoutManager es necesario para posicionar los elementos (en este caso, vertical)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // 4. Crea y asigna el Adapter
        val adapter = HistorialAdapter()
        recyclerView.adapter = adapter

        model.obtenerHistorial().observe(viewLifecycleOwner) { historialData ->
            adapter.submitList(historialData)

            if (historialData.isEmpty()) {
                vacio.visibility = View.VISIBLE
                contenido.visibility = View.INVISIBLE
            } else {
                vacio.visibility = View.INVISIBLE
                contenido.visibility = View.VISIBLE
            }
        }

        return view
    }
}
