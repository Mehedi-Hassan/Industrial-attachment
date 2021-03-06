package com.example.finalproject.userList.network

import android.util.Log
import android.widget.Toast
import com.example.finalproject.MainActivity
import com.example.finalproject.userList.model.PaginatedData
import com.example.finalproject.userList.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient(val networkCallback: NetworkCallback) {

    var userList: List<User> = mutableListOf()

    fun getUser(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiInterface = retrofit.create(ApiInterface::class.java)
        apiInterface.getUsers().enqueue(object : Callback<PaginatedData>{
            override fun onResponse(call: Call<PaginatedData>, response: Response<PaginatedData>) {
                if(response.isSuccessful){
                    val body = response.body()
                    if(body != null){
                        userList = body.data
                        networkCallback.getList(userList)
                    }
                }
            }

            override fun onFailure(call: Call<PaginatedData>, t: Throwable) {
                // TODO("Not yet implemented")
            }

        })
    }
}