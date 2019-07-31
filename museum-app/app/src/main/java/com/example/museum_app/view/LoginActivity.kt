package com.example.museum_app.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.museum_app.R
import com.example.museum_app.model.User
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            if(login() != null) {
                goToMuseumActivity()
            }
        }
    }

    fun login() : User? {
        var user = input_user.text.toString()
        var password = input_password.text.toString()
        return User.login(user, password)
    }

    fun goToMuseumActivity(){
        val intentExplicito = Intent(
            this,
            MuseumView:: class.java
        )
        startActivity(intentExplicito)
    }
}
