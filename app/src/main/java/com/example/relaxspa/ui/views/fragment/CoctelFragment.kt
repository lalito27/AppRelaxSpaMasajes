package com.example.relaxspa.ui.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.relaxspa.R
import com.example.relaxspa.databinding.FragmentCoctelBinding
import com.example.relaxspa.entity.Resultado
import com.example.relaxspa.ui.viewmodel.CoctelViewModel
import com.example.relaxspa.ui.viewmodel.CoctelViewModelFactory
import com.example.relaxspa.ui.views.adapter.CoctelAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.divider.MaterialDividerItemDecoration


class CoctelFragment : Fragment() {

    private var _binding: FragmentCoctelBinding? = null
    private val binding get() = _binding!!

    //agregando esto
    private val viewModel : CoctelViewModel by activityViewModels {
        CoctelViewModelFactory()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCoctelBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.listarCocteles()
        viewModel.listaCoctels.observe(viewLifecycleOwner){ resultado ->
            when (resultado) {
                is Resultado.Exito -> {
                    val lista = resultado.data
                    /*for (i in lista) {
                        println(i)
                    }*/
                    val adapter = CoctelAdapter(lista)
                    binding.rvCoctel.adapter = adapter
                    binding.rvCoctel.layoutManager = GridLayoutManager(requireContext(), 3) /*LinearLayoutManager*/
                    val divider = MaterialDividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL /*or LinearLayoutManager.HORIZONTAL*/)

                    val metric = resources.displayMetrics

                    divider.dividerInsetStart = (16f * metric.density).toInt() //16dp
                    divider.dividerInsetEnd = (16f * metric.density).toInt()   //16dp
                    divider.dividerColor = resources.getColor(R.color.purple_700,null)
                    divider.isLastItemDecorated = false
                    binding.rvCoctel.addItemDecoration(divider)

                }
                is Resultado.Problema -> {
                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle("Error")
                        .setMessage(resultado.error.mensaje)
                        .setPositiveButton("Aceptar", null)
                        .show()
                }
            }

        }

    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}