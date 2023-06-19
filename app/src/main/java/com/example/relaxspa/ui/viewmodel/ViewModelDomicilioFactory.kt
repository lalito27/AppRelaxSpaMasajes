package com.example.relaxspa.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.relaxspa.repository.DomicilioRepository

class ViewModelDomicilioFactory(val repository: DomicilioRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DomicilioViewModel::class.java)) {
            return DomicilioViewModel(repository) as T //clase generica as T
        }
        return super.create(modelClass)
    }

}