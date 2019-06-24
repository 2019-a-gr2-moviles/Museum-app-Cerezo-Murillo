package com.example.museum_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btn_singup.setOnClickListener {
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
