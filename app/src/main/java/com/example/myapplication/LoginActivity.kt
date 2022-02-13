package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.myapplication.model.User
import com.example.myapplication.network.NetworkClient
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btSignIn: FloatingActionButton = findViewById(R.id.btSignIn)
        btSignIn.setOnClickListener {
            val edtTxtEmail: EditText = findViewById(R.id.edtTxtEmail)
            val edtTxtPassword: EditText = findViewById(R.id.edtTxtPassword)

            val email = edtTxtEmail.text.toString().trim()
            val password = edtTxtPassword.text.toString().trim()

            if (email.isEmpty()) {
                edtTxtEmail.error = "Email required"
                edtTxtEmail.requestFocus()
                return@setOnClickListener
            }


            if (password.isEmpty()) {
                edtTxtPassword.error = "Password required"
                edtTxtPassword.requestFocus()
                return@setOnClickListener
            }
            
            NetworkClient.instance.userLogin(email, password)
                .enqueue(object : Callback<Any>{
                    override fun onResponse(call: Call<Any>, response: Response<Any>) {
                        if(response.isSuccessful){
                            // go to homeActivity
                        }
                        else{
                            Toast.makeText(applicationContext, "Try Again", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<Any>, t: Throwable) {

                    }
                })
        }
    }
}

private fun Any.enqueue(callback: Callback<User>) {

}
