package com.example.ia

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ColorDetailsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.colordetails)

        val id: TextView = findViewById(R.id.id)
        val name: TextView = findViewById(R.id.name)
        val year: TextView = findViewById(R.id.year)

        //val color: CardView = findViewById(R.id.color)
        val pantone_value: TextView = findViewById(R.id.value)

        val bundle: Bundle? = intent.extras
        val id2 = bundle!!.getString("id")
        val name2 = bundle!!.getString("name")
        val year2 = bundle!!.getString("year")
        //val color2 = bundle!!.getString("color")
        val pantone_value2 = bundle!!.getString("pantone_value")

        id.text = id2
        name.text = name2
        year.text = year2
        //color.setCardBackgroundColor()
        pantone_value.text = pantone_value2
    }
}