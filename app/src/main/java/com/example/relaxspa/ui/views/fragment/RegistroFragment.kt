package com.example.relaxspa.ui.views.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import com.example.relaxspa.Application
import com.example.relaxspa.R
import com.example.relaxspa.databinding.FragmentRegistroBinding
import com.example.relaxspa.room.UsuarioDao
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

            var nomb = binding.EDTNOMBRES.text.toString()
            var password = binding.txtPassword.text.toString()

            val nuevoUsuario = Producto (0, tcodigo, tnombre, tcantidad)
            pViewModel.insertar(nuevoProducto)

            var obj = Usuario(  EDTDNI.text.toString().toInt(), //DNI ES UNICO DEBE HABER VALIDACIONES.
                EDTNOMBRES.text.toString(),
                EDTAPELLIDOS.text.toString(),
                sexo,
                EDTDIRECPRI.text.toString(),
                EDTCELULAR.text.toString().toInt(),
                0)


            Toast.makeText(this, "Usuario ${nomb} registrado correctamente", Toast.LENGTH_LONG).show()

            var m = Intent(this, ServicatalogoActivity::class.java)
            startActivity(m)
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