package com.example.ia.network

import com.example.ia.model.PaginationColor
import retrofit2.http.GET

interface ApiInterfaceColor {
    @GET("unknown")
    fun getColors(): retrofit2.Call<PaginationColor>

}

