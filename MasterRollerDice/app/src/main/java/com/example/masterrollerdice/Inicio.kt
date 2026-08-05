package com.example.masterrollerdice

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.io.FileOutputStream
import java.io.OutputStreamWriter

/**
 * Fragmento del inicio
 */
class Inicio : Fragment() {
    /**
     * Crea la vista del fragmento
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_inicio, container, false)

        // Por defecto
        val eleccionDadosPorDefecto = 1
        val tipoPorDefecto = "D4"
        val textoTotal = view.findViewById<TextView>(R.id.total_text)

        // valores en origen
        var numDados = eleccionDadosPorDefecto
        var tipoDados = tipoPorDefecto

        // El tipo de dado ahora se guarda como un String
        val lanzador = view.findViewById<EditText>(R.id.lanzar_dados)
        lanzador.keyListener = null // Hacer que el EditText no sea editable
        val unDado = view.findViewById<EditText>(R.id.num_dados_elegidos1)
        unDado.keyListener = null // Hacer que el EditText no sea editable
        val dosDados = view.findViewById<EditText>(R.id.num_dados_elegidos2)
        dosDados.keyListener = null // Hacer que el EditText no sea editable

        // imagenes de los distintos cubos
        val d4Img = view.findViewById<View>(R.id.d4)
        val d6Img = view.findViewById<View>(R.id.d6)
        val d8Img = view.findViewById<View>(R.id.d8)
        val d10Img = view.findViewById<View>(R.id.d10)
        val d12Img = view.findViewById<View>(R.id.d12)
        val d20Img = view.findViewById<View>(R.id.d20)
        val d100Img = view.findViewById<View>(R.id.d100)

        // Mostrar texto sobre cuadro
        val mostar1 = view.findViewById<TextView>(R.id.mostrar1)
        val mostar2 = view.findViewById<TextView>(R.id.mostrar2)
        val mostar3 = view.findViewById<TextView>(R.id.mostrar3)

        // Elección central y fotos
        val soloUnDado = view.findViewById<View>(R.id.solo_un_dado)
        val variosDados = view.findViewById<View>(R.id.dos_dado)

        val fotoCentral1 = view.findViewById<ImageView>(R.id.foto_central1)
        val fotoCentral2 = view.findViewById<ImageView>(R.id.foto_central2)
        val fotoCentral3 = view.findViewById<ImageView>(R.id.foto_central3)

        // Listener de uno o dos dados
        unDado.setOnClickListener {
            numDados = 1
            soloUnDado.visibility = View.VISIBLE
            variosDados.visibility = View.INVISIBLE
            mostar1.text = "0"
            mostar2.text = "0"
            mostar3.text = "0"
            textoTotal.text = "Total: 0"
        }

        dosDados.setOnClickListener {
            numDados = 2
            soloUnDado.visibility = View.INVISIBLE
            variosDados.visibility = View.VISIBLE
            mostar1.text = "0"
            mostar2.text = "0"
            mostar3.text = "0"
            textoTotal.text = "Total: 0"
        }

        // Listener de operacion (sin sistema de guardado)
        lanzador.setOnClickListener {
            // 1. Comprueba si la vibración está habilitada desde MainActivity
            if (MainActivity.isVibrationEnabled) {
                // 2. Llama a la función para hacer vibrar el dispositivo
                vibrarDispositivo(requireContext())
            }
            var total = 0
            mostar1.text = "0"
            mostar2.text = "0"
            mostar3.text = "0"

            when (tipoDados) {
                "D4" -> {
                    val listaResultados = mutableListOf<Int>()
                    for (i in 1..numDados) {
                        listaResultados.add((1..4).random())
                    }
                    if (numDados == 1) {
                        mostar1.text = listaResultados[0].toString()
                    } else if (numDados == 2) {
                        mostar2.text = listaResultados[0].toString()
                        mostar3.text = listaResultados[1].toString()
                    }
                    textoTotal.text = "Total: ${listaResultados.sum()}"
                    total = listaResultados.sum()
                }

                "D6" -> {
                    val listaResultados = mutableListOf<Int>()
                    for (i in 1..numDados) {
                        listaResultados.add((1..6).random())
                    }
                    if (numDados == 1) {
                        mostar1.text = listaResultados[0].toString()
                    } else if (numDados == 2) {
                        mostar2.text = listaResultados[0].toString()
                        mostar3.text = listaResultados[1].toString()
                    }
                    textoTotal.text = "Total: ${listaResultados.sum()}"
                    total = listaResultados.sum()
                }

                "D8" -> {
                    val listaResultados = mutableListOf<Int>()
                    for (i in 1..numDados) {
                        listaResultados.add((1..8).random())
                    }
                    if (numDados == 1) {
                        mostar1.text = listaResultados[0].toString()
                    } else if (numDados == 2) {
                        mostar2.text = listaResultados[0].toString()
                        mostar3.text = listaResultados[1].toString()
                    }
                    textoTotal.text = "Total: ${listaResultados.sum()}"
                    total = listaResultados.sum()
                }
                "D10" -> {
                    val listaResultados = mutableListOf<Int>()
                    for (i in 1..numDados) {
                        listaResultados.add((1..10).random())
                    }
                    if (numDados == 1) {
                        mostar1.text = listaResultados[0].toString()
                    } else if (numDados == 2) {
                        mostar2.text = listaResultados[0].toString()
                        mostar3.text = listaResultados[1].toString()
                    }
                    textoTotal.text = "Total: ${listaResultados.sum()}"
                    total = listaResultados.sum()
                }
                "D12" -> {
                    val listaResultados = mutableListOf<Int>()
                    for (i in 1..numDados) {
                        listaResultados.add((1..12).random())
                    }
                    if (numDados == 1) {
                        mostar1.text = listaResultados[0].toString()
                    } else if (numDados == 2) {
                        mostar2.text = listaResultados[0].toString()
                        mostar3.text = listaResultados[1].toString()
                    }
                    textoTotal.text = "Total: ${listaResultados.sum()}"
                    total = listaResultados.sum()
                }
                "D20" -> {
                    val listaResultados = mutableListOf<Int>()
                    for (i in 1..numDados) {
                        listaResultados.add((1..20).random())
                    }
                    if (numDados == 1) {
                        mostar1.text = listaResultados[0].toString()
                    } else if (numDados == 2) {
                        mostar2.text = listaResultados[0].toString()
                        mostar3.text = listaResultados[1].toString()
                    }
                    textoTotal.text = "Total: ${listaResultados.sum()}"
                    total = listaResultados.sum()
                }
                "D100" -> {
                    val listaResultados = mutableListOf<Int>()
                    for (i in 1..numDados) {
                        listaResultados.add((1..100).random())
                    }
                    if (numDados == 1) {
                        mostar1.text = listaResultados[0].toString()
                    } else if (numDados == 2) {
                        mostar2.text = listaResultados[0].toString()
                        mostar3.text = listaResultados[1].toString()
                    }
                    textoTotal.text = "Total: ${listaResultados.sum()}"
                    total = listaResultados.sum()
                }
                else -> {
                    textoTotal.text = "Error"
                }
            }
            val filename = "historial.csv"
            // Leer el historial actual para contar lanzamientos
            val historialList = leerCSV(requireContext())
            val numLanzamientos = historialList.size + 1 // Siguiente número de lanzamiento
            val dataAEscribir = "$numLanzamientos,${numDados}$tipoDados,${total}\n"
            try {
                // Usa openFileOutput para escribir en el almacenamiento interno de la app.
                // MODE_APPEND es crucial: añade al final en lugar de sobrescribir.
                val outputStream: FileOutputStream = requireContext().openFileOutput(filename, Context.MODE_APPEND)

                // Escribe la cadena al archivo.
                OutputStreamWriter(outputStream).use { writer ->
                    writer.write(dataAEscribir)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Manejar el error de escritura (ej. almacenamiento lleno)
            }
        }

        // Listener de elegir dado
        d4Img.setOnClickListener {
            tipoDados = "D4"
            fotoCentral1.setImageResource(R.drawable.d4_sin_fondo)
            fotoCentral2.setImageResource(R.drawable.d4_sin_fondo)
            fotoCentral3.setImageResource(R.drawable.d4_sin_fondo)
        }
        d6Img.setOnClickListener {
            tipoDados = "D6"
            fotoCentral1.setImageResource(R.drawable.d6_sin_fondo)
            fotoCentral2.setImageResource(R.drawable.d6_sin_fondo)
            fotoCentral3.setImageResource(R.drawable.d6_sin_fondo)
        }
        d8Img.setOnClickListener {
            tipoDados = "D8"
            fotoCentral1.setImageResource(R.drawable.d8_sin_fondo)
            fotoCentral2.setImageResource(R.drawable.d8_sin_fondo)
            fotoCentral3.setImageResource(R.drawable.d8_sin_fondo)
        }
        d10Img.setOnClickListener {
            tipoDados = "D10"
            fotoCentral1.setImageResource(R.drawable.d10_sin_fondo)
            fotoCentral2.setImageResource(R.drawable.d10_sin_fondo)
            fotoCentral3.setImageResource(R.drawable.d10_sin_fondo)
        }
        d12Img.setOnClickListener {
            tipoDados = "D12"
            fotoCentral1.setImageResource(R.drawable.d12_sin_fondo)
            fotoCentral2.setImageResource(R.drawable.d12_sin_fondo)
            fotoCentral3.setImageResource(R.drawable.d12_sin_fondo)
        }
        d20Img.setOnClickListener {
            tipoDados = "D20"
            fotoCentral1.setImageResource(R.drawable.d20_sin_fondo)
            fotoCentral2.setImageResource(R.drawable.d20_sin_fondo)
            fotoCentral3.setImageResource(R.drawable.d20_sin_fondo)
        }
        d100Img.setOnClickListener {
            tipoDados = "D100"
            fotoCentral1.setImageResource(R.drawable.d100_sin_fondo)
            fotoCentral2.setImageResource(R.drawable.d100_sin_fondo)
            fotoCentral3.setImageResource(R.drawable.d100_sin_fondo)
        }

        return view
    }
}

/**
 * Función que hace vibrar el dispositivo
 */
private fun vibrarDispositivo(context: Context) {
    val vibrator = context.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

    // Comprueba si el dispositivo es Android 8 (Oreo) o superior
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // Para versiones nuevas, se usa VibrationEffect
        // VibrationEffect.createOneShot(duración_en_milisegundos, amplitud)
        // Amplitud: -1 = por defecto, 1-255 = intensidad de la vibración
        vibrator.vibrate(VibrationEffect.createOneShot(150, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        // Para versiones antiguas (obsoleto en API 26)
        vibrator.vibrate(150) // duración en milisegundos
    }
}
