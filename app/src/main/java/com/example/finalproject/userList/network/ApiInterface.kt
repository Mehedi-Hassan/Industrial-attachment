package com.example.finalproject.userList.network
import com.example.finalproject.userList.model.PaginatedData
import com.example.finalproject.userList.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("users")
    fun getUsers() : Call<PaginatedData>
}