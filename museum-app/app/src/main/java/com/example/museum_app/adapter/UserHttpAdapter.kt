package com.example.museum_app.adapter

import android.os.AsyncTask
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.museum_app.model.Person
import com.example.museum_app.model.User
import com.example.museum_app.view.MainActivity
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class UserHttpAdapter : AsyncTask<String, Integer, User?>(){

    override fun doInBackground(vararg params: String?): User? {
        var user = params[0]
        var pass = params[1]
        var currentUrl = "$url/login"
        val body = listOf(
            "userName" to user,
            "password" to pass
        )
        var usuario : User? = null
        val (request, response, result) = currentUrl
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

    val url = MainActivity.url

    fun register(body : Parameters){
        var currentUrl = "$url/User"
        currentUrl
            .httpPost(body)
            .responseString{ request, response, result ->
                when(result){
                    is Result.Failure -> {
                        var ex = result.getException()
                        Log.i("httpError", "Error: $ex")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        var newUser = Klaxon().parse<User>(data)
                        User.currentUser = newUser
                        val newBody = listOf(
                            "user_person_FK" to newUser!!.id
                        )
                        Person.adapter.updateClient(newBody, newUser.id)
                    }
                }

            }
    }

}