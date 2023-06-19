package com.example.relaxspa.repository

import com.example.relaxspa.data.CoctelDataSource
import com.example.relaxspa.entity.Coctel
import com.example.relaxspa.entity.Resultado

class CoctelRepository (private val dataSource: CoctelDataSource) {

    suspend fun listaCoctel() : Resultado<List<Coctel>> {
        return when (val response = dataSource.servicioCoctel()) {
            is Resultado.Exito -> {
                val lista = response.data.drinks
                Resultado.Exito(lista)
            }
            is Resultado.Problema -> {
                response
            }
        }
    }

}