package com.example.finalproject


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.homepage)

        val menuBar: FrameLayout = findViewById(R.id.menuBar)

        val bottomNavigationView:  BottomNavigationView  = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.icon_color -> {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }
                R.id.icon_user -> {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }

            }
            false
        }

        //menuBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}