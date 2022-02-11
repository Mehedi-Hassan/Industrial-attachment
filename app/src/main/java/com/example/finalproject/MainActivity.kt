package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.userList.model.User
import com.example.finalproject.userList.network.NetworkCallback
import com.example.finalproject.userList.network.NetworkClient

class MainActivity : AppCompatActivity(), NetworkCallback {
    private lateinit var recyclerView: RecyclerView
    private val networkClient = NetworkClient(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.users_list_layout)

        recyclerView = findViewById(R.id.rv)
        networkClient.getUser()
    }

    fun showData(dataList: List<User>){
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(dataList)
        recyclerView.adapter = adapter
    }

    override fun getList(userList: List<User>) {
        showData(userList)
    }
}