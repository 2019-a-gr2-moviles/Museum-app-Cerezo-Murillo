package com.example.museum_app.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.museum_app.R
import com.example.museum_app.model.Museum
import kotlinx.android.synthetic.main.activity_museum_detail_view.*

class MuseumDetailView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_detail_view)
        val museumId = intent.getIntExtra("museumId",0)
        fillMuseumDetail(museumId)

        btnEventsMuseumDetail.setOnClickListener {
            goToMuseumEvents(museumId)
        }

        btnAddressMuseumDetail.setOnClickListener {
            goToMuseumInMap(Museum.museums[museumId].latitude,Museum.museums[museumId].longitude)
        }
    }


    fun fillMuseumDetail(idMuseum:Int){

        txtNameMuseumDetail.text = Museum.museums[idMuseum].name
        txtBusinessDaysMuseumDetail.text = Museum.museums[idMuseum].businessDays
        txtBusinessHoursMuseumDetail.text = Museum.museums[idMuseum].businessHours
        txtDescriptionMuseumDetail.text = Museum.museums[idMuseum].description
        txtPriceMuseumDetail.text = Museum.museums[idMuseum].tags
        Glide.with(this).load(Museum.museums[idMuseum].image).into(imgDetailMuseum)
    }


    fun goToMuseumEvents(museumId:Int){
        val intentExplicito = Intent(
            this,
            EventView::class.java
        )
        intentExplicito.putExtra("museumId",museumId)
        startActivity(intentExplicito)
    }

    fun goToMuseumInMap(museumLat:String, museumLong:String){
//        val intentExplicito = Intent(
//            this,
//            EventView::class.java
//        )
//        intentExplicito.putExtra("museumLat",museumLat)
//        intentExplicito.putExtra("museumLong",museumLong)
//        startActivity(intentExplicito)
    }
}
