package com.example.relaxspa.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_domicilio")
class Domicilio(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "servicio_masaje") val servicio_masaje: String,
    @ColumnInfo(name = "direccion") val direccion: String,
    @ColumnInfo(name = "ciudad") val ciudad: String,
    @ColumnInfo(name = "fecha") val fecha: String,
    @ColumnInfo(name = "hora") val hora: String
) : Serializable {
    override fun toString(): String {
        return "Domicilio(id=$id, servicio_masaje='$servicio_masaje', direccion='$direccion', ciudad='$ciudad', fecha='$fecha', hora='$hora')"
    }
}