package com.example.relaxspa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.relaxspa.entity.Usuario
import com.example.relaxspa.repository.UsuarioRepository
import kotlinx.coroutines.launch


class UsuarioViewModel (private val repository: UsuarioRepository): ViewModel() {

    val usuarios:  LiveData<List<Usuario>> = repository.listaUsuarios.asLiveData() //componentes observables por la vista

    fun insertar(usuario: Usuario) {
        viewModelScope.launch {//coorutinas
            repository.insertar(usuario)
        }
    }

    fun actualizar(dni: String, nombres: String, apellidos: String, sexo: String, direccion: String, celular: String, pass: String, estado: Int) {
        viewModelScope.launch {//coorutinas
            repository.actualizar(dni, nombres, apellidos, sexo, direccion, celular, pass, estado)
        }
    }

    fun eliminar(dni: String) {
        viewModelScope.launch {//coorutinas
            repository.eliminar(dni)
        }
    }


}