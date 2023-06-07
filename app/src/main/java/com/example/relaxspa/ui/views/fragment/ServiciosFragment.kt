package com.example.relaxspa.ui.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.relaxspa.Application
import com.example.relaxspa.R
import com.example.relaxspa.databinding.FragmentRegistroBinding
import com.example.relaxspa.databinding.FragmentServiciosBinding
import com.example.relaxspa.ui.viewmodel.UsuarioViewModel
import com.example.relaxspa.ui.viewmodel.ViewModelFactory


class ServiciosFragment : Fragment() {

    private var _binding: FragmentServiciosBinding? = null

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
        _binding = FragmentServiciosBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        
        binding.btnServiSoli.setOnClickListener {
            var action1 = ServiciosFragmentDirections.actionServiciosFragmentToSolicitadosFragment(null)//puede ser nulo
            findNavController().navigate(action1)
        }

        binding.btnUsuarios.setOnClickListener {
            var action1 = ServiciosFragmentDirections.actionServiciosFragmentToSolicitadosFragment(null)//puede ser nulo
            findNavController().navigate(action1)
        }

        binding.btnContacto.setOnClickListener {
            var action1 = ServiciosFragmentDirections.actionServiciosFragmentToContactanosFragment()//puede ser nulo
            findNavController().navigate(action1)
        }

        //soolo para ver la lista un observador
        pViewModel.usuarios.observe(viewLifecycleOwner) {lista ->
            println("INFORMACION DE LA LISTA ${lista.size}")
            for (p in lista) {
                println(p.toString())
            }
        }
    }


}