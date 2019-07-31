package com.example.museum_app.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.museum_app.R
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
            MuseumView:: class.java
        )
        startActivity(intentExplicito)
    }

}
