package com.example.museum_app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_event_view.*
import kotlinx.android.synthetic.main.activity_museum_view.*

class EventView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_view)
        val lista = arrayListOf<Event>()
        val recyclerView = rvEvents
        lista.add(Event(R.drawable.musuem3,"Viaje al pasado", "13 - 25 Julio", "9 am - 4pm"))
        lista.add(Event(R.drawable.musuem3,"Viaje al fututo", "25 - 30 Julio", "9 am - 4pm"))
        lista.add(Event(R.drawable.museum2,"Con los incas", "18 - 15 Julio", "9 am - 4pm"))
        lista.add(Event(R.drawable.museum2,"Con los incas", "18 - 15 Julio", "9 am - 4pm"))
        startRecyclerView(lista,this,recyclerView)

    }


    fun startRecyclerView(list: ArrayList<Event>, activity:EventView, recycler_view: RecyclerView){
        val eventAdapter = EventAdapter(
            list,
            activity,
            recycler_view
        )
        recycler_view.adapter = eventAdapter
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(activity)


    }
}
