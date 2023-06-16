package com.example.relaxspa.entity

/**Estructura de datos del json*/
class CoctelResult (val strDrink: String?, //tragofuerte
                    val strDrinkThumb: String?,
                    val idDrink: String?){

    override fun toString(): String {
        return "CoctelResult(strDrink=$strDrink, strDrinkThumb=$strDrinkThumb, idDrink=$idDrink)"
    }
}

