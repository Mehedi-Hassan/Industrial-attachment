package com.example.finalproject.network

import com.example.finalproject.model.RegisterData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterfaceRegistration {

    @FormUrlEncoded
    @POST("register")
    fun createUser(
        @Field("email") email:String,
        @Field("password") password:String,
    ): Call<RegisterData>
}