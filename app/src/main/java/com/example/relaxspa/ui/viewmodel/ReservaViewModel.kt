package com.example.relaxspa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.relaxspa.entity.Reserva
import com.example.relaxspa.repository.ReservaRepository
import kotlinx.coroutines.launch

class ReservaViewModel(private val repository: ReservaRepository) : ViewModel() {

    val reservas: LiveData<List<Reserva>> = repository.listaReservas.asLiveData()

    fun insert(reserva: Reserva) {
        viewModelScope.launch {
            repository.insert(reserva)
        }
    }

    fun update(servicioCorte: String, fecha: String, hora: String, id: Int) {
        viewModelScope.launch {
            repository.actualizar(servicioCorte, fecha, hora, id)
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            repository.eliminar(id)
        }
    }
}