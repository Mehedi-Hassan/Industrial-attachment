package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.userList.model.User
import com.example.finalproject.userList.network.NetworkCallback
import com.example.finalproject.userList.network.NetworkClient
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btUserList: MaterialButton = findViewById(R.id.btUserList)
        btUserList.setOnClickListener{
            val intent = Intent(this, UserListActivity::class.java)
            startActivity(intent)
        }
    }
}