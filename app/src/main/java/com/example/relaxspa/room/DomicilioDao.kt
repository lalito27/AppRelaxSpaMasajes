package com.example.relaxspa.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.relaxspa.entity.Domicilio
import kotlinx.coroutines.flow.Flow

@Dao
interface DomicilioDao {
    @Query("SELECT * FROM tb_domicilio")
    fun getDomicilios(): Flow<List<Domicilio>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(domicilio: Domicilio)

    @Query("UPDATE tb_domicilio SET servicio_masaje = :servicio_masaje, direccion = :direccion, ciudad = :ciudad, fecha = :fecha, hora = :hora WHERE id = :id")
    suspend fun update(servicio_masaje: String, direccion: String, ciudad: String, fecha: String, hora: String, id: Int)

    @Query("DELETE FROM tb_domicilio WHERE id = :id")
    suspend fun delete(id: Int)
}