package com.example.relaxspa.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.relaxspa.data.CoctelDataSource
import com.example.relaxspa.repository.CoctelRepository

class CoctelViewModelFactory: ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoctelViewModel::class.java)) {
            return CoctelViewModel(CoctelRepository(CoctelDataSource())) as T
        }
        return super.create(modelClass)
    }
}