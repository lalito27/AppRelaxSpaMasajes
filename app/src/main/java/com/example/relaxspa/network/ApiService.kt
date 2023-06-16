package com.example.relaxspa.network

import com.example.relaxspa.entity.CoctelResult
import retrofit2.http.GET

interface ApiService {
    /**Servicios**/

    @GET("api/json/v1/1/filter.php?a=Non_Alcoholic") /*método*/ /*pokeapi.co/api/v2/pokemon?offset=0&limit=250*/
    suspend fun obtenerTrago(): CoctelResult
}