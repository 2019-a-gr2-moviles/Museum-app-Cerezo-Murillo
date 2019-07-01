package com.example.museum_app.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.museum_app.R
import com.example.museum_app.model.Museum
import com.example.museum_app.view.MuseumView

class MuseumAdapter(private val museumList: List<Museum>,
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

            museumEventButton.setOnClickListener {
                context.goToEvents()
            }

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
        myViewHolder.museumImageView.setImageBitmap(museum.image)

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