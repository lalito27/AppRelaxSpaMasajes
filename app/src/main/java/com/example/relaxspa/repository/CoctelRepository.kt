package com.example.relaxspa.repository

import com.example.relaxspa.data.CoctelDataSource
import com.example.relaxspa.entity.CoctelResult
import com.example.relaxspa.entity.Resultado

class CoctelRepository (private val dataSource: CoctelDataSource) {

    suspend fun listaCoctel() : Resultado<CoctelResult> {
        return when (val response = dataSource.servicioCoctel()) {
            is Resultado.Exito -> {
                val lista = response.data
                Resultado.Exito(lista)
            }
            is Resultado.Problema -> {
                response
            }
        }
    }

}