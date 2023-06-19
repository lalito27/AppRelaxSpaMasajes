package com.example.relaxspa.ui.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import com.example.relaxspa.databinding.FragmentCatalogoBinding
import com.example.relaxspa.databinding.FragmentServicatalogoBinding

class ServicatalogoFragment : Fragment() {

    private var _binding: FragmentServicatalogoBinding? = null
    private val binding get() = _binding!!

    private var _binding1: FragmentCatalogoBinding? = null
    private val binding2 get() = _binding1!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentServicatalogoBinding.inflate(inflater, container, false)
        return binding.root
        _binding1 = FragmentCatalogoBinding.inflate(inflater, container, false)
        return binding2.root
    }


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNuestroServi.setOnClickListener {
            var action = ServicatalogoFragmentDirections.actionServicatalogoFragmentToServiciosFragment(null)//puede ser nulo
           findNavController().navigate(action)
        }

        binding.btnCatalogo.setOnClickListener{
             var action1= ServicatalogoFragmentDirections.actionServicatalogoFragmentToCatalogoFragment()
              findNavController().navigate(action1)
        }

        binding.btnNuestrosCocteles.setOnClickListener {
             var action2= ServicatalogoFragmentDirections.actionServicatalogoFragmentToCoctelFragment()
             findNavController().navigate(action2)
        }
        binding.btnSalir.setOnClickListener {
            requireActivity().finish()
        }


    }
}
