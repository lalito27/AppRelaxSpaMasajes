package com.example.relaxspa.ui.views.fragment

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.example.relaxspa.R
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DomicilioFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DomicilioFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var normal: Double = 0.0
    var escolar: Double = 0.0
    var militar: Double = 0.0
    var moderno: Double = 0.0
    var corte: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //

        //

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_domicilio, container, false)
        val cal = Calendar.getInstance()
        val dia = cal.get(Calendar.DAY_OF_MONTH)
        val mes = cal.get(Calendar.MONTH)
        val anio = cal.get(Calendar.YEAR)
        val hora = cal.get(Calendar.HOUR_OF_DAY)
        val minuto = cal.get(Calendar.MINUTE)
        view.findViewById<TextView>(R.id.TVFECHA)?.text = "$dia/${mes + 1}/$anio"
        view.findViewById<EditText>(R.id.EDTHORA)?.setText("$hora:$minuto")

        val btnConfirmar = view.findViewById<Button>(R.id.btnConfirmar)
        val edtHora = view.findViewById<EditText>(R.id.EDTHORA)
        var rdbNormald = view.findViewById<RadioButton>(R.id.RDBNORMALD)
        edtHora.setText("$hora:$minuto")
        view.findViewById<EditText>(R.id.EDTHORA)?.setText("$hora:$minuto")
        view.findViewById<Button>(R.id.BTNHORA)?.setOnClickListener {
            val tp = TimePickerDialog(
                requireContext(),
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    view.findViewById<EditText>(R.id.EDTHORA)?.setText("$hourOfDay:$minute")
                },
                hora,
                minuto,
                false
            )
            tp.show()
        }

        btnConfirmar.setOnClickListener {
            var corte: String = ""

            if (rdbNormald.isChecked) {
                corte = "Normal"
          /*  } else if (RDBESCOLARD.isChecked) {
                corte = "Escolar"
            } else if (RDBMILITARD.isChecked) {
                corte = "Militar"
            } else if (RDBMODERNOD.isChecked) {
                corte = "Moderno"
                */

            }

            val crud = CorteDAO(requireContext())
            val obj = Domicilio(corte, TVFECHA.text.toString(), EDTHORA.text.toString())
            crud.GrabarDomicilio(obj)

            Toast.makeText(requireContext(), "Nueva Solicitud Grabado Correctamente", Toast.LENGTH_LONG)
                .show()
        }



        return view
    }

    fun BotonRegresar(a: View) {
        //    var q = Intent(this, ServiciosActivity::class.java)
        //    startActivity(q)
    }

    fun botonConfirmar() {

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DomicilioFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DomicilioFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}