package com.example.ia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.Color
import model.ColorAdapter
import network.NetworkCallbackColor
import network.NetworkClientColor

class MainActivity : AppCompatActivity(), NetworkCallbackColor {
    private lateinit var rcView: RecyclerView
    private val networkClient = NetworkClientColor(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.colordetailsrecyclerview)
        rcView = findViewById(R.id.rv)
        networkClient.getColor()
    }

    fun showData(colorList: List<Color>) {
        rcView.layoutManager = LinearLayoutManager(this)
        val adapter = ColorAdapter(colorList)
        rcView.adapter = adapter
    }

    override fun getColor(colorList: List<Color>) {
        showData(colorList)
    }

}