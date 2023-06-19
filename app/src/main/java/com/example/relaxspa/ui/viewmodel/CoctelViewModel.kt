package com.example.relaxspa.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.relaxspa.entity.Coctel
import com.example.relaxspa.entity.Resultado
import com.example.relaxspa.repository.CoctelRepository
import kotlinx.coroutines.launch

class CoctelViewModel (private val repository: CoctelRepository): ViewModel(){

    private var _listaCoctel = MutableLiveData<Resultado<List<Coctel>>> ()
    var listaCoctels: LiveData<Resultado<List<Coctel>>> = _listaCoctel
    fun listarCocteles() {
        viewModelScope.launch {
            val response = repository.listaCoctel()
            _listaCoctel.value = response

        }

    }
}