package com.example.museum_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_to_login.setOnClickListener {
            goToLoginActivity()
        }

        btn_to_signup.setOnClickListener {
            goToSignUpActivity()
        }

//
//        btn2.setOnClickListener {
//            val intentExplicito = Intent(
//                this,
//                EventView::class.java
//            )
//            startActivity(intentExplicito)
//        }

    }

    fun goToLoginActivity(){
        val intent = Intent(
            this,
            LoginActivity :: class.java
        )
        startActivity(intent)
    }

    fun goToSignUpActivity(){
        val intent = Intent(
            this,
            SignUpActivity :: class.java
        )
        startActivity(intent)
    }

}
