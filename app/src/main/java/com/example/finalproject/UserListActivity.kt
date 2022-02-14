package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.userList.UserAdapter
import com.example.finalproject.userList.model.User
import com.example.finalproject.userList.network.NetworkCallback
import com.example.finalproject.userList.network.NetworkClient

class UserListActivity: AppCompatActivity(), NetworkCallback, UserAdapter.OnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private val networkClient = NetworkClient(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.users_list_layout)

        recyclerView = findViewById(R.id.rv)
        networkClient.getUser()
    }

    private fun showData(dataList: List<User>){
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UserAdapter(dataList, this)
        recyclerView.adapter = adapter
    }

    override fun getList(userList: List<User>) {
        showData(userList)
    }

    override fun onItemClicked(user: User) {
        val intent = Intent(this, SingleProfileActivity::class.java)
        intent.putExtra("first_name", user.first_name)
        intent.putExtra("last_name", user.last_name)
        intent.putExtra("email", user.email)
        intent.putExtra("avatar", user.avatar)
        startActivity(intent)
    }
}