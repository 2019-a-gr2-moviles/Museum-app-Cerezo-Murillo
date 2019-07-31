package com.example.museum_app.model
import com.example.museum_app.view.MainActivity

class Event(
    var id : Int,
    var name: String,
    var dateStart:String,
    var timeStart:String,
    var endDate : String,
    var endTime : String,
    var description : String
) {

    var image : String

    init {
        image = "${MainActivity.url}/pictureEvent?id=$id"
    }

}