package com.example.museum_app.adapter

import android.os.AsyncTask
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.museum_app.model.User
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class UserHttpAdapter : AsyncTask<String, Integer, User?>(){

    override fun doInBackground(vararg params: String?): User? {
        var user = params[0]
        var pass = params[1]
        val body = listOf(
            "userName" to user,
            "password" to pass
        )
        var usuario : User? = null
        val (request, response, result) = url
            .httpPost(body)
            .responseString()

        when(result){
            is Result.Failure ->{
                val ex = result.getException()
                Log.i("testingxd", "Error $ex")
            }
            is Result.Success -> {
                val data = result.get()
                Log.i("testingxd", "$data")
                var usuarioAux = Klaxon().parse<User>(data)
                if(usuarioAux != null){
                    usuario = usuarioAux
                    User.currentUser = usuario
                    Log.i("testingxd", "${usuario!!.id}")
                }
            }
        }

        return usuario
    }

    val url = "http://192.168.0.8:1337/login"

}