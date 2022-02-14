package com.example.finalproject
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.card.MaterialCardView


class ColorDetailsActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_details)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Color Details"
        }

        val id: TextView = findViewById(R.id.id)
        val name: TextView = findViewById(R.id.name)
        val year: TextView = findViewById(R.id.year)
        val color: MaterialCardView = findViewById(R.id.color)
        val pantone_value: TextView = findViewById(R.id.value)
        val code: TextView = findViewById(R.id.code)

        val bundle: Bundle? = intent.extras
        val id2 = bundle!!.getString("id")
        val name2 = bundle!!.getString("name")
        val year2 = bundle!!.getString("year")
        val color2 = bundle!!.getString("code")
        val pantone_value2 = bundle!!.getString("pantone_value")

        id.text = id2
        name.text = name2
        year.text = year2
        color.setBackgroundColor(Color.parseColor(color2))
        pantone_value.text = pantone_value2
        code.text = color2
    }
}