package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.textview.MaterialTextView
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class SingleProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.single_profile)

        val tvFirstName: MaterialTextView = findViewById(R.id.first_name)
        val tvLastName: MaterialTextView = findViewById(R.id.last_name)
        val tvEmail: MaterialTextView = findViewById(R.id.email)
        val ivAvatar: ShapeableImageView = findViewById(R.id.avatar)

        val bundle: Bundle? = intent.extras
        val firstName = bundle!!.getString("first_name")
        val lastName = bundle!!.getString("last_name")
        val email = bundle!!.getString("email")
        val avatar = bundle!!.getString("avatar")

        tvFirstName.text = firstName
        tvLastName.text = lastName
        tvEmail.text = email
        Picasso.get().load(avatar).into(ivAvatar)
    }
}