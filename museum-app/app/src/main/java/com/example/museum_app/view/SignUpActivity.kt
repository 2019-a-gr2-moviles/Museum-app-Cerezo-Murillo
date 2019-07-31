package com.example.museum_app.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.museum_app.R
import com.example.museum_app.model.Person
import com.example.museum_app.model.User
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlin.math.sign

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btn_singup.setOnClickListener {
            signUp()
            Thread.sleep(1000)
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
            "name" to input_name.text.toString(),
            "lastName" to input_last_name.text.toString(),
            "emailAddress" to input_email.text.toString()
        )

        var userName = input_user.text.toString()
        var password = input_password.text.toString()

        Person.adapter.register(bodyPerson,userName,password)
    }

    fun logIn(){
        var newEmail = input_user.text.toString()
        var newPass = input_password.text.toString()
        if(User.login(newEmail,newPass) != null){
            goToMuseumActivity()

        }
    }

}
