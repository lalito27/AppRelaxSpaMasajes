package com.example.relaxspa.entity

/**Estructura de datos*/
sealed class Resultado<out T> {
    data class Exito<out T: Any>(val data: T): Resultado<T> ()
    data class Problema(val error: Error): Resultado<Nothing> ()
}