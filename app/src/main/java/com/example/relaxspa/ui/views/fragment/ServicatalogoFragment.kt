package com.example.relaxspa.ui.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.relaxspa.R
import com.example.relaxspa.databinding.FragmentRegistroBinding
import com.example.relaxspa.databinding.FragmentServicatalogoBinding


class ServicatalogoFragment : Fragment() {

    private var _binding: FragmentServicatalogoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentServicatalogoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNuestroServi.setOnClickListener {
    //        var action = ServicatalogoFragmentDirections.actionServicatalogoFragmentToServiciosFragment(null)//puede ser nulo
    //        findNavController().navigate(action)
        }

    }
}
