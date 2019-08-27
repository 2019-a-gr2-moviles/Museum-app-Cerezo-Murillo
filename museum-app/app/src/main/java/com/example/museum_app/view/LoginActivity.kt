package com.example.museum_app.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.museum_app.R
import com.example.museum_app.model.User
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.input_password
import kotlinx.android.synthetic.main.activity_login.input_user
import kotlinx.android.synthetic.main.activity_sign_up.*

class LoginActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
//            if(login() != null) {
//                goToMuseumActivity()
//            }
            firebaseLogin()
        }
    }

    fun login() : User? {
        var user = input_user.text.toString()
        var password = input_password.text.toString()
        return User.login(user, password)
    }

    fun firebaseLogin(){
        auth.signInWithEmailAndPassword(input_user.text.toString(), input_password.text.toString())
            .addOnCompleteListener{ task ->
                if (task.isSuccessful){
                    goToMuseumActivity()
                } else {
                    Toast.makeText(this, "Incorrect E-mail or Password.", Toast.LENGTH_SHORT).show()
                    input_password.setText("")
                }
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
