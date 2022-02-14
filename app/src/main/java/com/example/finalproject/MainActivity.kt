package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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