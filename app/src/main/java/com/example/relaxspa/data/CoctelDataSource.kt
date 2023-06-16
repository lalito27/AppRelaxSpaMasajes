package com.example.relaxspa.data

import com.example.relaxspa.entity.CoctelResult
import com.example.relaxspa.entity.Resultado
import com.example.relaxspa.network.ConexionApi
import java.net.SocketTimeoutException
import com.example.relaxspa.entity.Error

class CoctelDataSource {

    suspend fun servicioCoctel(): Resultado<CoctelResult> {
        try {
            val result = ConexionApi.retrofitService.obtenerTrago()
            return Resultado.Exito(result)
        } catch (ex: Exception) {
            println("ERROR $ex")
            return Resultado.Problema(Error("001","Error: $ex"))

        } catch (ex: SocketTimeoutException) {
            println("ERROR $ex")
            return Resultado.Problema(Error("002","Error: $ex"))
        }

    }
}