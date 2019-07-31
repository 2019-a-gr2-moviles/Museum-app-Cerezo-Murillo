package com.example.museum_app.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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


    fun startRecyclerView(list: List<Museum>, activity: MuseumView, recycler_view: androidx.recyclerview.widget.RecyclerView){
        val museumAdapter = MuseumAdapter(
            list,
            activity,
            recycler_view
        )
        recycler_view.adapter = museumAdapter
        recycler_view.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recycler_view.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
    }



    fun goToEvents(museumId: Int){
        val intentExplicito = Intent(
            this,
            EventView::class.java
        )
        intentExplicito.putExtra("museumId",museumId)
        startActivity(intentExplicito)
    }

    fun goToMuseumAddress(lat:String, long: String, name:String){
        val intentExplicito = Intent(
            this,
            MuseumAddressMapsActivity::class.java
        )
        intentExplicito.putExtra("museumLat",lat)
        intentExplicito.putExtra("museumLong",long)
        intentExplicito.putExtra("museumName",name)

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
