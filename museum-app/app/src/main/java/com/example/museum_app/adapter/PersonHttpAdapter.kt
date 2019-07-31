package com.example.museum_app.adapter

import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.museum_app.model.Person
import com.example.museum_app.view.MainActivity
import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.kittinunf.result.Result

class PersonHttpAdapter {

    val url = MainActivity.url

    fun getPersonById (id : Int) : Person? {
        var currentUrl = "$url/Person/$id"
        var personToReturn : Person? = null
        currentUrl
            .httpGet()
            .responseString{ request, response, result ->
                when(result){
                    is Result.Failure ->{
                        var exception = result.getException()
                        Log.i("testingxd", "Error : $exception")
                    }
                    is Result.Success -> {
                        var data = result.get()
                        personToReturn = Klaxon().parse<Person>(data)
                        Person.currentPerson = personToReturn
                    }
                }

            }
        return personToReturn
    }

    fun newPerson(body : Parameters){
        var currentUrl = "$url/Person"
        currentUrl
            .httpPost(body)
            .responseString{ request, response, result ->
                when(result){
                    is Result.Failure -> {
                        var ex = result.getException()
                        Log.i("testingxd", "$ex")
                    }
                    is Result.Success -> {
                        var data = result.get()
                        var personToReturn = Klaxon().parse<Person>(data)
                        Person.currentPerson = personToReturn
                    }
                }

            }
    }

}