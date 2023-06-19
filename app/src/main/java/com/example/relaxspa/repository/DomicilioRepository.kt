package com.example.relaxspa.repository

import com.example.relaxspa.entity.Domicilio
import com.example.relaxspa.room.DomicilioDao
import kotlinx.coroutines.flow.Flow

class DomicilioRepository(private val domicilioDao: DomicilioDao) {
    val listaDomicilios: Flow<List<Domicilio>> = domicilioDao.getDomicilios()

    suspend fun insert(domicilio: Domicilio) {
        domicilioDao.insert(domicilio)
    }
    suspend fun update(servicio_masaje: String, direccion: String, ciudad: String, fecha: String, hora: String, id: Int) {
        domicilioDao.update(servicio_masaje, direccion, ciudad, fecha,  hora, id)
    }
    suspend fun delete(id: Int) {
        domicilioDao.delete(id)
    }
}