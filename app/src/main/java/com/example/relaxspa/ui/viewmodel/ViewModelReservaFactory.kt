package com.example.relaxspa.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.relaxspa.repository.ReservaRepository

class ViewModelReservaFactory(val repository: ReservaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(ReservaViewModel::class.java)) {
            return ReservaViewModel(repository) as T //clase generica as T
        }
        return super.create(modelClass)
    }

}