package com.example.relaxspa.ui.views.fragment

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.relaxspa.Application
import com.example.relaxspa.R
import com.example.relaxspa.databinding.FragmentDomicilioBinding
import com.example.relaxspa.entity.Domicilio
import com.example.relaxspa.ui.viewmodel.DomicilioViewModel
import com.example.relaxspa.ui.viewmodel.ViewModelDomicilioFactory
import java.util.*


class DomicilioFragment : Fragment() {

    private var _binding: FragmentDomicilioBinding? = null

    private val binding get() = _binding!!

    //Importante agregar esto
    private val pViewModel: DomicilioViewModel by activityViewModels {
        val repository = (requireActivity().application as Application).repository2
        ViewModelDomicilioFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDomicilioBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var cal = Calendar.getInstance()
        var dia = cal.get(Calendar.DAY_OF_MONTH)
        var mes = cal.get(Calendar.MONTH)
        var anio = cal.get(Calendar.YEAR)
        var hora = cal.get(Calendar.HOUR_OF_DAY)
        var minuto = cal.get(Calendar.MINUTE)

        binding.TVFECHA.text = ""+ dia + "/" + (mes + 1) + "/" + anio
        binding.EDTHORA.setText("" + "$hora" + ":" + "$minuto")


        binding.BTNHORA.setOnClickListener {
            var tp = TimePickerDialog(requireContext(), { view, horaDia, minuto ->
                binding.EDTHORA.setText("" + horaDia + ":" + minuto)
            }, hora, minuto, false)
            tp.show()
        }

        binding.BTNCONFIRMAR.setOnClickListener {
            var tipmasaje:String = ""

            if (binding.rdbMsjPareja.isChecked)
            {
                tipmasaje = "En Pareja"
            }
            else if (binding.rdbMsjTerapeutico.isChecked)
            {
                tipmasaje = "Escolar"
            }
            else if(binding.rdbMsjDescon.isChecked)
            {
                tipmasaje = "Militar"
            }
            else if(binding.rdbMsjRelajante.isChecked)
            {
                tipmasaje = "Moderno"
            }

            val edtDireccion = binding.edtDireccion.text.toString()
            val cmbCiudad = binding.cmbCiudad.selectedItem.toString()
            val editHora = binding.EDTHORA.text.toString()
            val tvFecha =  binding.TVFECHA.text.toString()

            if (edtDireccion.isNotBlank() && editHora.isNotBlank() && tvFecha.isNotBlank()) {
                val registrarDomicilio = Domicilio (0, tipmasaje, edtDireccion, cmbCiudad,editHora, tvFecha)
            pViewModel.insert(registrarDomicilio)

            Toast.makeText(view.context,"Nueva Solicitud: ${id} Grabada Correctamente", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(view.context, "Solicitud No Guardada!!.. :(", Toast.LENGTH_SHORT).show()
        }
        }

        binding.btnRegresar.setOnClickListener {
            var action3 = DomicilioFragmentDirections.actionDomicilioFragmentToServiciosFragment(null)
            findNavController().navigate(action3)
        }
        //soolo para ver la lista un observador
        pViewModel.domicilios.observe(viewLifecycleOwner) {lista ->
            println("INFORMACION DE LA LISTA ${lista.size}")
            for (p in lista) {
                println(p.toString())
            }
        }
    }


}