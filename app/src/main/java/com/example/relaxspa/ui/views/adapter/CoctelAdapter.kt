package com.example.relaxspa.ui.views.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.relaxspa.databinding.ItemCoctelBinding
import com.example.relaxspa.entity.Coctel


class CoctelAdapter(val lista: List<Coctel>) : Adapter<CoctelViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoctelViewHolder {
       val binding = ItemCoctelBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CoctelViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: CoctelViewHolder, position: Int) {
        val coctel = lista[position]
        holder.bind(coctel)
    }
}