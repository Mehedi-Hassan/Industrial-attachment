package com.example.finalproject

import ColorListAdapter
import NetworkCallbackColor
import NetworkClientColor
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.model.Color

class ColorList : AppCompatActivity() , NetworkCallbackColor, ColorListAdapter.OnItemClickListener{
    private lateinit var rcView: RecyclerView
    private val networkClient = NetworkClientColor(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.colorlistrecycleview)
        rcView = findViewById(R.id.rv)
        networkClient.getColor()

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Color List"
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
    }

    fun showData(colorList: List<Color>) {
        rcView.layoutManager = LinearLayoutManager(this)
        val adapter = ColorListAdapter(colorList, this)
        rcView.adapter = adapter
    }

    override fun getColor(colorList: List<Color>) {
        showData(colorList)
    }
    override fun onItemClicked(color: Color) {
        val intent = Intent(this, ColorDetailsActivity::class.java)
        intent.putExtra("id", color.id.toString())
        intent.putExtra("name", color.name)
        intent.putExtra("year", color.year.toString())
        intent.putExtra("pantone_value", color.pantone_value)
        intent.putExtra("code", color.color)
        startActivity(intent)
    }

}