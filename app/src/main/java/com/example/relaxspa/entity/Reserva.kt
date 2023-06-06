package com.example.relaxspa.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_reserva")
class Reserva(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "r_servicio_masaje") val r_servicio_masaje: String?,
    @ColumnInfo(name = "r_fecha") val fecha: String?,
    @ColumnInfo(name = "r_hora") val hora: String?
) : Serializable {
    override fun toString(): String {
        return "Reserva(id=$id, r_servicio_masaje=$r_servicio_masaje, fecha=$fecha, hora=$hora)"
    }
}