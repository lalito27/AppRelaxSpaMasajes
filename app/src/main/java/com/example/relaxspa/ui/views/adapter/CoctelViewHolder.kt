package com.example.relaxspa.ui.views.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.relaxspa.databinding.ItemCoctelBinding
import com.example.relaxspa.entity.Coctel

class CoctelViewHolder (private val binding: ItemCoctelBinding) : ViewHolder(binding.root){
    fun bind(coctel: Coctel) {
        binding.lblTrago.text = coctel.strDrink
        /*val lista = pokemon.url.split("/")
        val idPokemon = lista[lista.size - 2]
        val urlPhoto = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/$idPokemon.png"
        Glide.with(itemView.context)
            .load(urlPhoto)
            .centerCrop()
            .into(binding.imgPokemon)
        //binding.imgPokemon ???*/
    }
}