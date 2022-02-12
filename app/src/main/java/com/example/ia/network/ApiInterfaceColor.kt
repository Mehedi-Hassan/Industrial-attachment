package com.example.ia.network

import PaginationColor
import retrofit2.http.GET

interface ApiInterfaceColor {
    @GET("unknown")
    fun getColors(): retrofit2.Call<PaginationColor>

}

