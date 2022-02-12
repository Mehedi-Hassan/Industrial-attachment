package com.example.ia.network

import com.example.ia.model.Color
import com.example.ia.model.PaginationColor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClientColor(val networkCallbackColor : NetworkCallbackColor) {
    var colorList: List<Color> = mutableListOf()
    fun getColor() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val apiInterface = retrofit.create(ApiInterfaceColor::class.java)
        apiInterface.getColors().enqueue(object : retrofit2.Callback<PaginationColor> {
            override fun onResponse(call: retrofit2.Call<PaginationColor>, response: retrofit2.Response<PaginationColor>) {
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body!= null){
                        colorList=body.data
                        networkCallbackColor.getColor(colorList)
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<PaginationColor>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}


