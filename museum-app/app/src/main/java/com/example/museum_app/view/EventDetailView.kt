package com.example.museum_app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.museum_app.R
import com.example.museum_app.model.Museum
import kotlinx.android.synthetic.main.activity_event_detail_view.*

class EventDetailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_detail_view)
        val museumId = intent.getIntExtra("museumId",0)
        val eventId = intent.getIntExtra("eventId",0)
        fillEventInformation(eventId,museumId)
    }


    fun fillEventInformation(idEvent:Int, idMuseum:Int){
        txtMuseumNameEventDetail.text // =Museum.museums[idMuseum]
        txtNameEventDetail.text
        txtBusinessDaysEventDetail.text
        txtBusinessHoursEventDetail.text
        txtDescriptionEventDetail.text
        txtPriceEventDetail.text

    }
}
