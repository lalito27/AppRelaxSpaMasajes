package com.example.relaxspa.ui.views.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.relaxspa.databinding.ItemspaBinding
import com.example.relaxspa.entity.Usuario

class UsuarioViewHolder (private val binding: ItemspaBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(usuario: Usuario) {
        binding.txtNomApeUsuario.text = usuario.nombres + " " + usuario.apellidos
        binding.txtDni.text = usuario.dni
        binding.txtDireccion.text = usuario.direccion
        binding.txtCelular.text = usuario.celular
    }

}