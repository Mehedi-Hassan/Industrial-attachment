package com.example.ia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homebutton)
        val button: Button = findViewById(R.id.colordetails)
        button.setOnClickListener {
            val intent = Intent(this, ColorDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}