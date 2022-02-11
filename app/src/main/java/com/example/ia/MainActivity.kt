package com.example.ia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homebutton)
        val button: Button = findViewById(R.id.colordetails)
        button.setOnClickListener {
            val intent = Intent(this, ColorDetailsActivity::class.java)
            startActivity(intent)
        }
        val colorlist: CardView = findViewById(R.id.colorlist)
        colorlist.setOnClickListener {
            val intent = Intent(this, ColorList::class.java)
            startActivity(intent)
        }
    }
}