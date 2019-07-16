package com.example.museum_app.model

import android.util.Log
import com.example.museum_app.adapter.UserHttpAdapter
import java.lang.Exception

class User (
    var id : Int,
    var userName : String,
    var user_person_FK : Int
) {

    init {
        Person.updateCurrentPerson(user_person_FK)
    }

    companion object{
        var currentUser : User? = null
        var adapter = UserHttpAdapter()

        fun login(user : String, pass : String) : User? {
            return adapter.execute(user, pass).get()
        }
    }

}