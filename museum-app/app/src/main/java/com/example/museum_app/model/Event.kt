package com.example.museum_app.model

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
        image = "http://192.168.0.8:1337/pictureEvent?id=$id"
    }

}