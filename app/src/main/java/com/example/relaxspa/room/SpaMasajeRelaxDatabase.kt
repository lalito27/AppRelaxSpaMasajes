package com.example.relaxspa.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.relaxspa.entity.Usuario


@Database(entities = [Usuario::class], version = 1) // colocamos los nombres de la clase que soporta
// y la versión va a incrementar con el tiempo si agregamos una nueva tabla o columna
//clase abstracta
abstract class SpaMasajeRelaxDatabase: RoomDatabase() { //El Nombre debe diferente

    abstract fun usuarioDao(): UsuarioDao

    companion object { //lo declarado es estatico
        private var INSTANCE: SpaMasajeRelaxDatabase? = null

        fun getInstance(context: Context): SpaMasajeRelaxDatabase {
            return INSTANCE ?: synchronized(this) {
                val obj = Room.databaseBuilder(context, SpaMasajeRelaxDatabase::class.java, "BDSpaMasajes_Relax").allowMainThreadQueries().build()
                INSTANCE = obj
                obj
            }

        }

    }

}