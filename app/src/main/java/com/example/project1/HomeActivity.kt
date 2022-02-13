package com.example.project1


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

        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.icon_color -> {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.icon_user -> {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivity(intent)
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }
        val menuBar: FrameLayout = findViewById(R.id.menuBar)

        //menuBar.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}