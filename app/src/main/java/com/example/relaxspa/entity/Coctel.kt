package com.example.relaxspa.entity

class Coctel (val strDrink: String?, //tragofuerte
              val strDrinkThumb: String?,
              val idDrink: String?){

    override fun toString(): String {
        return "Coctel(strDrink=$strDrink, strDrinkThumb=$strDrinkThumb, idDrink=$idDrink)"
    }
}