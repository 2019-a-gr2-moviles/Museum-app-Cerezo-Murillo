package com.example.museum_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_museum_view.*
import kotlinx.android.synthetic.main.ly_museum.*

class MuseumView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_view)
        val lista = arrayListOf<Museum>()
        val recyclerView = rvMuseums
        lista.add(Museum(R.drawable.museum1,"Casa de alabado","todos los dias", "7-9 am"))
        lista.add(Museum(R.drawable.museum2,"Museo de la moneda","lunes a viernes", "10-5 am"))
        lista.add(Museum(R.drawable.musuem3,"Museo de Cera","solo jueves", "9 -4 am"))
        startRecyclerView(lista,this,recyclerView)

    }


    fun startRecyclerView(list: ArrayList<Museum>, activity:MuseumView, recycler_view: RecyclerView){
        val museumAdapter =MuseumAdapter(
            list,
            activity,
            recycler_view
        )
        recycler_view.adapter = museumAdapter
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.layoutManager = LinearLayoutManager(activity)
    }

    fun goToEvents(){
        val intentExplicito = Intent(
            this,
            EventView::class.java
        )
        startActivity(intentExplicito)
    }
}
