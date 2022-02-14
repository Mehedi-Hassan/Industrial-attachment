package com.example.finalproject.network

import PaginationColor
import retrofit2.http.GET

interface ApiInterfaceColor {
    @GET("unknown")
    fun getColors(): retrofit2.Call<PaginationColor>

}

