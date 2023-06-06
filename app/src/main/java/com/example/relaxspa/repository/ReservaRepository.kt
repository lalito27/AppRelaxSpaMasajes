package com.example.relaxspa.repository

import com.example.relaxspa.entity.Reserva
import com.example.relaxspa.room.ReservaDao
import kotlinx.coroutines.flow.Flow

class ReservaRepository(private val reservaDao: ReservaDao) {

    val listaReservas: Flow<List<Reserva>> = reservaDao.getReservas()

    suspend fun insert(reserva: Reserva) {
        reservaDao.insert(reserva)
    }

    fun actualizar(servicioMasaje: String, fecha: String, hora: String, id: Int) {
        reservaDao.update(servicioMasaje, fecha, hora, id)
    }

    fun eliminar(id: Int) {
        reservaDao.delete(id)
    }

}