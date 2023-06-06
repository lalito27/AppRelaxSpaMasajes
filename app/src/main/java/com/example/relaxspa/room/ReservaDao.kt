package com.example.relaxspa.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.relaxspa.entity.Reserva
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservaDao {
    @Query("SELECT * FROM tb_reserva")
    fun getReservas(): Flow<List<Reserva>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(reserva: Reserva)

    @Query("UPDATE tb_reserva SET r_servicio_masaje = :servicioMasaje, r_fecha = :fecha, r_hora = :hora WHERE id = :id")
    open fun update(servicioMasaje: String, fecha: String, hora: String, id: Int)

    @Query("DELETE FROM tb_reserva WHERE id = :id")
    open fun delete(id: Int)
}