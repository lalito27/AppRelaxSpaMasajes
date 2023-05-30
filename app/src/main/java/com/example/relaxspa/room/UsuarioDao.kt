package com.example.relaxspa.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.relaxspa.entity.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao  {
    //en las interfaces se declaran las funciones y los parametros que devolveran

    @Query("SELECT * FROM tb_usuario")
    fun getUsuarios(): Flow<List<Usuario>>

    //suspend se ejecutan en un hilo secundario
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(producto: Usuario)

    @Query("UPDATE tb_usuario set dni_usuario=:dni,nombres_usuario=:nombres,apellidos_usuario=:apellidos,sexo_usuario=:sexo,direccion_usuariou=:direccion,celular_usuario=:celular, contrasenia_usuario=:pass, estado_usuario=:estado " +
            "where dni_usuario = :dni")
    open fun update(dni: String, nombres: String, apellidos: String, sexo: String, direccion: String, celular: String, pass: String, estado: Int)
    //@Update
    //suspend fun update (producto: Producto)

    //@Delete
    //suspend fun delete (producto: Producto)
    @Query("DELETE FROM tb_usuario WHERE dni_usuario = :dni")
    open fun delete(dni: String)

}