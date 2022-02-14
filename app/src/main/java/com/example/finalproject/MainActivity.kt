package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.finalproject.model.User
import com.example.finalproject.network.NetworkClientLogin
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

            NetworkClientLogin.instance.userLogin(email, password)
                .enqueue(object : Callback<Any>{
                    override fun onResponse(call: Call<Any>, response: Response<Any>) {
                        if(response.isSuccessful){
                            // go to homeActivity

                            val intent = Intent(applicationContext, HomeActivity::class.java)
                            startActivity(intent)
                        }
                        else{
                            Toast.makeText(applicationContext, "Try Again", Toast.LENGTH_SHORT).show()
                        }
                    }
                    override fun onFailure(call: Call<Any>, t: Throwable) {

                    }
                })

        }

        val btRegister : Button = findViewById(R.id.btRegister)
        btRegister.setOnClickListener{
            //go to RegisterActivity

            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}

private fun Any.enqueue(callback: Callback<User>) {

}
