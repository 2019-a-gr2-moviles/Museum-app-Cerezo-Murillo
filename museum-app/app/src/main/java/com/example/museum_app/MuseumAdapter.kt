package com.example.museum_app

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MuseumAdapter(private val museumList: ArrayList<Museum>,
                    private val context: MuseumView,
                    private val recyclerView: RecyclerView
) : RecyclerView.Adapter<MuseumAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var museumNameTextView: TextView
        var museumBusinessHoursTextView: TextView
        var museumBusinessDaysTextView: TextView
        var museumImageView: ImageView
        var museumEventButton: Button
        var museumAddressButton : Button


        init {

            museumNameTextView = view.findViewById(R.id.tvMuseumName) as TextView
            museumBusinessHoursTextView = view.findViewById(R.id.tvBusinessHours) as TextView
            museumBusinessDaysTextView = view.findViewById(R.id.tvBusinessDays) as TextView
            museumImageView = view.findViewById(R.id.imageMuseum) as ImageView
            museumEventButton = view.findViewById(R.id.btnMuseumEvents)
            museumAddressButton = view.findViewById(R.id.btnMuseumAddress)

        }

    }

    override fun getItemCount(): Int {
        return museumList.size
    }

    override fun onBindViewHolder(
        myViewHolder: MuseumAdapter.MyViewHolder,
        position: Int
    ) {

        val museum = museumList[position]

        myViewHolder.museumNameTextView.text = museum.museumName
        myViewHolder.museumBusinessDaysTextView.text = museum.museumBusinessDays
        myViewHolder.museumBusinessHoursTextView.text = museum.museumBusinessHours
        myViewHolder.museumImageView.setImageResource(museum.museumImage)

    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ):
            MuseumAdapter.MyViewHolder {
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