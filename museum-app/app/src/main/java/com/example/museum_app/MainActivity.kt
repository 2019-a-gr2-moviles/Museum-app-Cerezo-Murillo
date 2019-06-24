package com.example.museum_app

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.ly_museum.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            val intentExplicito = Intent(
                this,
                MuseumView::class.java
            )
            startActivity(intentExplicito)
        }

        btn2.setOnClickListener {
            val intentExplicito = Intent(
                this,
                EventView::class.java
            )
            startActivity(intentExplicito)
        }

    }

}
