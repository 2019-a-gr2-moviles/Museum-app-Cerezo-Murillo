package com.example.museum_app

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class EventAdapter(private val eventList: ArrayList<Event>,
                   private val context: EventView,
                   private val recyclerView: RecyclerView
) : RecyclerView.Adapter<EventAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var eventNameTextView: TextView
        var eventBusinessHoursTextView: TextView
        var eventDateTextView: TextView
        var eventImageView: ImageView


        init {

            eventNameTextView = view.findViewById(R.id.tvEventName) as TextView
            eventBusinessHoursTextView = view.findViewById(R.id.tvEventBusinessHours) as TextView
            eventDateTextView = view.findViewById(R.id.tvEventDate) as TextView
            eventImageView = view.findViewById(R.id.imageEvent) as ImageView


        }

    }

    override fun onBindViewHolder(
        myViewHolder: EventAdapter.MyViewHolder,
        position: Int
    ) {

        val event = eventList[position]

        myViewHolder.eventNameTextView.text = event.eventName
        myViewHolder.eventDateTextView.text = event.eventDate
        myViewHolder.eventBusinessHoursTextView.text = event.eventBusinessHours
        myViewHolder.eventImageView.setImageResource(event.eventImage)

    }

    override fun getItemCount(): Int {
        return eventList.size
    }


    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ):
            EventAdapter.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.ly_event,
                p0,
                false
            )

        return MyViewHolder(itemView)
    }

}