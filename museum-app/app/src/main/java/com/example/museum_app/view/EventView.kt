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
import kotlinx.android.synthetic.main.activity_event_view.*

class EventView : AppCompatActivity() {

    var museumId:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_view)
        museumId = intent.getIntExtra("museumId",0)
        val lista = arrayListOf<Event>()
        val recyclerView = rvEvents
        lista.add(
            Event(
                R.drawable.musuem3,
                "Viaje al pasado",
                "13 - 25 Julio",
                "9 am - 4pm"
            )
        )
        lista.add(
            Event(
                R.drawable.musuem3,
                "Viaje al fututo",
                "25 - 30 Julio",
                "9 am - 4pm"
            )
        )
        lista.add(
            Event(
                R.drawable.museum2,
                "Con los incas",
                "18 - 15 Julio",
                "9 am - 4pm"
            )
        )
        lista.add(
            Event(
                R.drawable.museum2,
                "Con los incas",
                "18 - 15 Julio",
                "9 am - 4pm"
            )
        )
        startRecyclerView(lista,this,recyclerView)

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
            EventView::class.java
        )
        intentExplicito.putExtra("museumId",museumId)
        intentExplicito.putExtra("eventId",eventId)
        startActivity(intentExplicito)
    }

}
