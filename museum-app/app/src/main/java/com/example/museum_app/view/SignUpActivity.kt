package com.example.museum_app.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.museum_app.R
import com.example.museum_app.model.User
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlin.math.sign

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btn_singup.setOnClickListener {
            signUp()
            Thread.sleep(100)
            logIn()
        }
    }

    fun goToMuseumActivity(){

        val intentExplicito = Intent(
            this,
            MuseumView:: class.java
        )
        startActivity(intentExplicito)
    }

    fun signUp(){

        var bodyPerson = listOf(
            "name" to input_name.text,
            "lastName" to input_last_name.text,
            "emailAddress" to input_email.text
        )

        var bodyUser = listOf(
            "userName" to input_user.text,
            "password" to input_password.text
        )


    }

    fun logIn(){
        var newEmail = input_user.text.toString()
        var newPass = input_password.text.toString()
        if(User.login(newEmail,newPass) != null){
            goToMuseumActivity()

        }
    }

}
