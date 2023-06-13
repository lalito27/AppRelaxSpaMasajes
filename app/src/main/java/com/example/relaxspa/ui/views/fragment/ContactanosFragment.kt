package com.example.relaxspa.ui.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.relaxspa.R
import com.example.relaxspa.databinding.FragmentCatalogoBinding
import com.example.relaxspa.databinding.FragmentContactanosBinding


class ContactanosFragment : Fragment() {

    private var _binding: FragmentContactanosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContactanosBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    binding.btnAtras.setOnClickListener {
        var action = ContactanosFragmentDirections.actionContactanosFragmentToServiciosFragment(null)
        findNavController().navigate(action)
    }
    }

}