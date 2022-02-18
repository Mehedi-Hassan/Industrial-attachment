package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.finalproject.network.NetworkClientRegister
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val button: FloatingActionButton = findViewById(R.id.button1)
        val emailid: EditText = findViewById(R.id.edtTxtEmailReg)
        val passwordid: EditText = findViewById(R.id.edtTxtPasswordReg)

        val loginButton: Button = findViewById(R.id.button2)
        loginButton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {

            val email = emailid.text.toString().trim()
            val password = passwordid.text.toString().trim()


            if (email.isEmpty()) {
                emailid.error = "Email required"
                emailid.requestFocus()
                return@setOnClickListener
            }


            if (password.isEmpty()) {
                passwordid.error = "Password required"
                passwordid.requestFocus()
                return@setOnClickListener
            }
            if (!password.contains(regex = Regex("[0-9]+"))) {
                passwordid.error = "numeric required"
                passwordid.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 8) {
                passwordid.error = "Minimum 8 character required"
                passwordid.requestFocus()
                return@setOnClickListener
            }


            NetworkClientRegister.instance.createUser(email, password)
                .enqueue(object : Callback<Any> {

                    override fun onResponse(
                        call: Call<Any>,
                        response: Response<Any>
                    ) {
                        if(response.isSuccessful){
                            val intent = Intent(applicationContext, HomeActivity::class.java)
                            startActivity(intent)
                        }
                    }

                    override fun onFailure(call: Call<Any>, t: Throwable) {

                    }

                })

        }

    }
}