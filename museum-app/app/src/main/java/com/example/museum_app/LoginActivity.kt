package com.example.museum_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            goToMuseumActivity()
        }
    }

    fun goToMuseumActivity(){
        val intentExplicito = Intent(
            this,
            MuseumView :: class.java
        )
        startActivity(intentExplicito)
    }
}
