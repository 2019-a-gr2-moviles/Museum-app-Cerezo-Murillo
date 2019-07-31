package com.example.museum_app.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.Log
import com.example.museum_app.adapter.MuseumHttpAdapter
import com.example.museum_app.view.MainActivity

class Museum(
    var id : Int,
    var name: String,
    var businessDays:String,
    var businessHours:String,
    var description : String,
    var phoneNumber : String,
    var tags : String,
    var longitude : String,
    var latitude : String,
    var events : ArrayList<Event>
) {

   var image : String

    init {
        image = "${MainActivity.url}/picture?id=$id"
    }


    companion object{
        var museums = listOf<Museum>()
        private var adapter : MuseumHttpAdapter = MuseumHttpAdapter()

        fun refreshList(){
            museums = adapter.getAll()!!
        }

    }


}