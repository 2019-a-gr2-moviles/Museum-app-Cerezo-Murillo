package com.example.museum_app.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.museum_app.adapter.EventAdapter
import com.example.museum_app.R
import com.example.museum_app.model.Event
import com.example.museum_app.model.Museum
import kotlinx.android.synthetic.main.activity_event_view.*

class EventView : AppCompatActivity() {

    var museumId:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_view)
        museumId = intent.getIntExtra("museumId",0)
        val recyclerView = rvEvents
        startRecyclerView(Museum.museums[museumId].events,this,recyclerView)

    }


    fun startRecyclerView(list: ArrayList<Event>, activity: EventView, recycler_view: androidx.recyclerview.widget.RecyclerView){
        val eventAdapter = EventAdapter(
            list,
            activity,
            recycler_view
        )
        recycler_view.adapter = eventAdapter
        recycler_view.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)


    }

    fun goToEventDetail(eventId:Int){
        val intentExplicito = Intent(
            this,
            EventDetailView::class.java
        )
        intentExplicito.putExtra("museumId",museumId)
        intentExplicito.putExtra("eventId",eventId)
        startActivity(intentExplicito)
    }

}
