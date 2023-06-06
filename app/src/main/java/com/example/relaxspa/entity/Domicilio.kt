package com.example.relaxspa.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tb_domicilio")
class Domicilio(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "direccion") val direccion: String,
    @ColumnInfo(name = "ciudad") val ciudad: String,
    @ColumnInfo(name = "codigo_postal") val codigoPostal: String
) : Serializable {
    override fun toString(): String {
        return "Domicilio(id=$id, direccion='$direccion', ciudad='$ciudad', codigoPostal='$codigoPostal')"
    }

}