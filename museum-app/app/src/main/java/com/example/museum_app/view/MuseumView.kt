package com.example.museum_app.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.museum_app.adapter.MuseumAdapter
import com.example.museum_app.R
import com.example.museum_app.adapter.MuseumHttpAdapter
import com.example.museum_app.model.Museum
import kotlinx.android.synthetic.main.activity_museum_view.*

class MuseumView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_view)
        val lista = Museum.museums
        val recyclerView = rvMuseums
        startRecyclerView(lista,this,recyclerView)

    }


    fun startRecyclerView(list: List<Museum>, activity: MuseumView, recycler_view: RecyclerView){
        val museumAdapter = MuseumAdapter(
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


    fun gotToMuseumDetail(museumId:Int){
        val intentExplicito = Intent(
            this,
            MuseumDetailView::class.java
        )
        intentExplicito.putExtra("museumId",museumId)
        startActivity(intentExplicito)
    }
}
