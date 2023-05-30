package com.example.relaxspa.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "tb_usuario")
class Usuario (@PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id" ) val id: Int = 0,
               @ColumnInfo(name = "dni_usuario") val dni: String?,
               @ColumnInfo(name = "nombres_usuario") val nombres: String?,
               @ColumnInfo(name = "apellidos_usuario") val apellidos: String?,
               @ColumnInfo(name = "sexo_usuario" ) val sexo: String?,
               @ColumnInfo(name = "direccion_usuariou" ) val direccion: String?,
               @ColumnInfo(name = "celular_usuario" ) val celular: String?,
               @ColumnInfo(name = "contrasenia_usuario" ) val pass: String?,
               @ColumnInfo(name = "estado_usuario" ) val estado: Int?): Serializable {//solo clases serializables se peuden transferir

    override fun toString(): String {
        return "Usuario(id=$id, dni=$dni, nombres=$nombres, apellidos=$apellidos, sexo=$sexo, direccion=$direccion, celular=$celular, pass=$pass, estado=$estado)"
    }
}
