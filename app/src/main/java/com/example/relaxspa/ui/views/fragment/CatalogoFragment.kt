package com.example.relaxspa.ui.views.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.relaxspa.R
import com.example.relaxspa.databinding.FragmentServicatalogoBinding
import com.example.relaxspa.databinding.FragmentCatalogoBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CatalogoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CatalogoFragment : Fragment() {

    private var _binding: FragmentCatalogoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCatalogoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.BotonAtras.setOnClickListener {
            var action = CatalogoFragmentDirections.actionCatalogoFragmentToServicatalogoFragment2(null)
            findNavController().navigate(action)
        }

    }
}