package com.example.relaxspa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.relaxspa.entity.Domicilio
import com.example.relaxspa.repository.DomicilioRepository
import kotlinx.coroutines.launch

class DomicilioViewModel(private val repository: DomicilioRepository) : ViewModel() {

    val domicilios: LiveData<List<Domicilio>> = repository.listaDomicilios.asLiveData()

    fun insert(domicilio: Domicilio) {
        viewModelScope.launch {
            repository.insert(domicilio)
        }
    }

    fun update(calle: String, numero: String, ciudad: String, id: Int) {
        viewModelScope.launch {
            repository.update(calle, numero, ciudad, id)
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            repository.delete(id)
        }
    }
}