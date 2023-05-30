package com.example.relaxspa.repository

import com.example.relaxspa.entity.Usuario
import com.example.relaxspa.room.UsuarioDao
import kotlinx.coroutines.flow.Flow

class UsuarioRepository (private val usuDao: UsuarioDao) {

    val listaUsuarios: Flow<List<Usuario>> = usuDao.getUsuarios()


    suspend fun insertar(usuario: Usuario) {
        usuDao.insert(usuario)
    }

    fun actualizar(dni: String, nombres: String, apellidos: String, sexo: String, direccion: String, celular: String, pass: String, estado: Int) {
        usuDao.update(dni, nombres, apellidos, sexo, direccion, celular, pass, estado)
    }

    //suspend fun eliminar(producto: Producto) {
    //    prodDao.delete(producto)
    //}

    fun eliminar(dni: String) {
        usuDao.delete(dni)
    }

}