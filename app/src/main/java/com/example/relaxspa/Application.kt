package com.example.relaxspa

import android.app.Application
import com.example.relaxspa.repository.UsuarioRepository
import com.example.relaxspa.room.SpaMasajeRelaxDatabase

class Application: Application() { //la clase  application
    val database by lazy { SpaMasajeRelaxDatabase.getInstance(this) } //solo se ejecuta cuando se invoca
    val repository by lazy { UsuarioRepository(database.usuarioDao()) }

}