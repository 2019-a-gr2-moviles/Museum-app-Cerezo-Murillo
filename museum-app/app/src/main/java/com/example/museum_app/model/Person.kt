package com.example.museum_app.model

import com.example.museum_app.adapter.PersonHttpAdapter
import com.github.kittinunf.fuel.core.Parameters

class Person (
    var id : Int,
    var name : String,
    var lastName : String,
    var emailAddress : String,
    var createdAt : Long,
    var updatedAt: Long
) {

    companion object{
        var currentPerson : Person? = null
        private var adapter = PersonHttpAdapter()

        fun updateCurrentPerson(id : Int){
            adapter.getPersonById(id)
        }
    }

    fun signup(data : Parameters){
        adapter.newPerson(data)
    }

}