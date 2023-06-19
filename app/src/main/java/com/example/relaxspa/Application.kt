package com.example.relaxspa

import android.app.Application
import com.example.relaxspa.repository.DomicilioRepository
import com.example.relaxspa.repository.ReservaRepository
import com.example.relaxspa.repository.UsuarioRepository
import com.example.relaxspa.room.SpaMasajeRelaxDatabase

class Application: Application() { //la clase  application
    val database by lazy { SpaMasajeRelaxDatabase.getInstance(this) } //solo se ejecuta cuando se invoca
    val repository by lazy { UsuarioRepository(database.usuarioDao()) }
    val repository2 by lazy { DomicilioRepository(database.domicilioDao()) }
    val repository3 by lazy { ReservaRepository(database.reservaDao()) }
}