package com.example.ia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ia.model.Color
import com.example.ia.model.ColorListAdapter
import com.example.ia.network.NetworkCallbackColor
import com.example.ia.network.NetworkClientColor

class ColorList : AppCompatActivity() , NetworkCallbackColor , ColorListAdapter.OnItemClickListener{
    private lateinit var rcView: RecyclerView
    private val networkClient = NetworkClientColor(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.colorlistrecycleview)
        rcView = findViewById(R.id.rv)
        networkClient.getColor()
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
        intent.putExtra("id", color.id)
        intent.putExtra("name", color.name)
        intent.putExtra("year", color.year)
        intent.putExtra("phantone_value", color.pantone_value)
        startActivity(intent)
    }

}