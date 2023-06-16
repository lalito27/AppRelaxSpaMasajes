package com.example.relaxspa.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.relaxspa.entity.CoctelResult
import com.example.relaxspa.entity.Resultado
import com.example.relaxspa.repository.CoctelRepository
import kotlinx.coroutines.launch

class CoctelViewModel (private val repository: CoctelRepository): ViewModel(){

    private var _listaCoctel = MutableLiveData<Resultado<CoctelResult>> ()

    fun listarCocteles() {
        viewModelScope.launch {
            val response = repository.listaCoctel()
            _listaCoctel.value = response

        }

    }
}