package com.example.relaxspa.ui.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.relaxspa.databinding.ItemspaBinding
import com.example.relaxspa.entity.Usuario

class UsuarioAdapter(var lista : List<Usuario>, val onclick: (Usuario) -> Unit) : RecyclerView.Adapter<UsuarioViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):UsuarioViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemspaBinding.inflate(inflater, parent, false)
        return UsuarioViewHolder(binding)
    }

    override fun getItemCount(): Int { // espera retornar un valor entero
        return lista.size
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val user= lista[position]
        holder.bind(user)
        holder.itemView.setOnClickListener {
            onclick(user)
        }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Definir los elementos de la vista del elemento de la lista
    }
}