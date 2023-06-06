package com.example.relaxspa.ui.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.relaxspa.Application
import com.example.relaxspa.R
import com.example.relaxspa.databinding.FragmentServiciosBinding
import com.example.relaxspa.ui.viewmodel.UsuarioViewModel
import com.example.relaxspa.ui.viewmodel.ViewModelFactory
import androidx.lifecycle.Observer
import com.example.relaxspa.databinding.FragmentSolicitadosBinding
import com.example.relaxspa.entity.Usuario
import com.example.relaxspa.ui.views.adapter.UsuarioAdapter

class SolicitadosFragment : Fragment() {

    private var _binding: FragmentSolicitadosBinding? = null
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
        _binding = FragmentSolicitadosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Crear el Observer para actualizar la UI
        val nameObserver = Observer<List<Usuario>> { usuario ->
            // Crear una instancia del adaptador personalizado y establecerlo en el RecyclerView
            val adapter = UsuarioAdapter(usuario) { usu ->
                println("HIZO CLICK EN ${usu.nombres}")

            }
            binding.rvUsuarios.adapter = adapter
            /// Observar los cambios en el LiveData
        }

        pViewModel.usuarios.observe(viewLifecycleOwner, nameObserver)
    }
}