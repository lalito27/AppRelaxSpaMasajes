package com.example.relaxspa.ui.views.fragment

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.relaxspa.Application
import com.example.relaxspa.databinding.FragmentRegistroBinding
import com.example.relaxspa.entity.Usuario
import com.example.relaxspa.ui.viewmodel.UsuarioViewModel
import com.example.relaxspa.ui.viewmodel.ViewModelFactory

class RegistroFragment : Fragment() {

    private var _binding: FragmentRegistroBinding? = null

    private val binding get() = _binding!!

    //Importante agregar esto
    private val pViewModel: UsuarioViewModel by activityViewModels {
        val repository = (requireActivity().application as Application).repository
        ViewModelFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegistroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*fun navegarAFragmentoNuevo() {
            val fragmentNuevo = ServicatalogoFragment() // aqui hay que cambiarlo por el fragment que le sigue
            if (isAdded) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.servicatalogoFragment, fragmentNuevo) //cambiar aqui tambien
                    .addToBackStack(null) // Agrega la transacción a la pila para permitir retroceder
                    .commit()
            }
        }*/
        
        binding.BTNREGISTRAR.setOnClickListener {

            var sexo:String = ""
            if (binding.RDBF.isChecked)
            {
                sexo= "Femenino"
            }
            else if (binding.RDBM.isChecked)
            {
                sexo = "Masculino"
            }
            val dni = binding.EDTDNI.text.toString()
            val nombres = binding.EDTNOMBRES.text.toString()
            val apellidos = binding.EDTAPELLIDOS.text.toString()
            val password = binding.txtPassword.text.toString()
            val direccion= binding.EDTDIRECPRI.text.toString()
            val celular = binding.EDTCELULAR.text.toString()

            if (dni.isNotBlank() && nombres.isNotBlank() && apellidos.isNotBlank() && sexo.isNotBlank() && direccion.isNotBlank()
                && celular.isNotBlank() && password.isNotBlank() ) {


            val grabarUsuario = Usuario(0, dni, nombres, apellidos, sexo, direccion, celular, password, 1)
            pViewModel.insertar(grabarUsuario)

            Toast.makeText(view.context,"Usuario ${nombres} registrado correctamente", Toast.LENGTH_LONG).show()
                var action = RegistroFragmentDirections.actionRegistroFragmentToServicatalogoFragment(null)//puede ser nulo
                findNavController().navigate(action)
            }
            else {
                Toast.makeText(view.context, "Registro No Guardado!!.. :(", Toast.LENGTH_SHORT).show()
            }
        }
        binding.BTNCANCELAR.setOnClickListener {
            var alertsalida = AlertDialog.Builder(requireContext())
            alertsalida.setTitle("Confirmar cierre")
            alertsalida.setMessage("¿Desea salir de la aplicación?")
            //establecer 2 botones
            //Confirmar
            alertsalida.setPositiveButton("SI", DialogInterface.OnClickListener { dialog, which ->
                requireActivity().finish()
            })
            //Cancelar
            alertsalida.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
            })
            alertsalida.show()
        }


    }

}