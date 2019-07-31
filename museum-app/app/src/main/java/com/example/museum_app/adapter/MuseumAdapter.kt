package com.example.museum_app.adapter

import android.content.Context
import android.content.Intent
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.museum_app.R
import com.example.museum_app.model.Museum
import com.example.museum_app.view.EventView
import com.example.museum_app.view.MuseumView

class MuseumAdapter(private val museumList: List<Museum>,
                    private val context: MuseumView,
                    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) : androidx.recyclerview.widget.RecyclerView.Adapter<MuseumAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

        var museumNameTextView: TextView
        var museumBusinessHoursTextView: TextView
        var museumBusinessDaysTextView: TextView
        var museumImageView: ImageView
        var museumEventButton: Button
        var museumAddressButton : Button
        var museumly : ConstraintLayout


        init {

            museumNameTextView = view.findViewById(R.id.tvMuseumName) as TextView
            museumBusinessHoursTextView = view.findViewById(R.id.tvBusinessHours) as TextView
            museumBusinessDaysTextView = view.findViewById(R.id.tvBusinessDays) as TextView
            museumImageView = view.findViewById(R.id.imageMuseum) as ImageView
            museumEventButton = view.findViewById(R.id.btnMuseumEvents)
            museumAddressButton = view.findViewById(R.id.btnMuseumAddress)
            museumly = view.findViewById(R.id.lyMuseum)



        }

    }

    override fun getItemCount(): Int {
        return museumList.size
    }

    override fun onBindViewHolder(
        myViewHolder: MyViewHolder,
        position: Int
    ) {

        val museum = museumList[position]

        myViewHolder.museumNameTextView.text = museum.name
        myViewHolder.museumBusinessDaysTextView.text = museum.businessDays
        myViewHolder.museumBusinessHoursTextView.text = museum.businessHours
        Glide.with(context).load(museum.image).into(myViewHolder.museumImageView)
        myViewHolder.museumly.setOnClickListener {
            Log.i("museumId", position.toString())
            context.gotToMuseumDetail(position)
        }

        myViewHolder.museumEventButton.setOnClickListener {
            context.goToEvents(position)
        }

        myViewHolder.museumAddressButton.setOnClickListener {
            context.goToMuseumAddress(Museum.museums[position].latitude, Museum.museums[position].longitude,Museum.museums[position].name )
        }

    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ):
            MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.ly_museum,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }





}