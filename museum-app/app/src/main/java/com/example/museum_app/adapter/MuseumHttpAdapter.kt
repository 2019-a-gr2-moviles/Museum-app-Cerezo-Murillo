package com.example.museum_app.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.util.Log
import com.beust.klaxon.Klaxon
import com.example.museum_app.model.Museum
import com.github.kittinunf.fuel.core.Headers
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import java.io.InputStream

class MuseumHttpAdapter {

    val url = "http://192.168.0.8:1337"

    fun getAll() : List<Museum>? {
        var currentUrl = "$url/allMuseums"

        var museumList : ArrayList<Museum>? = arrayListOf()
        currentUrl
            .httpGet()
            .responseString { request, response, result ->
                when(result){
                    is Result.Failure -> {
                        val ex =result.getException()
                        Log.i("testingxd", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        val data = result.get()
                        Log.i("testingxd",data)
                        try {
                            val museumListAux = Klaxon().parseArray<Museum>(data)
                            Log.i("testingxd","here we are")
                            museumListAux?.forEach {
                                museumList!!.add(it)
                            }
                        }catch (e : Exception){
                            Log.i("testingxd", "Error buscando museos: $e")
                        }
                    }
                }
            }
        return museumList
    }

    fun getImage(id : Int) : Bitmap? {
        var x : Bitmap? = null
        var currentUrl = "$url/picture?id=$id"
        Log.i("testingxd", currentUrl)
        val (request, response, result) = currentUrl.httpGet()
            .header(Headers.CONTENT_TYPE, "image/jpg")
            .responseString()
        when(result){
            is Result.Failure -> {
                val ex =result.getException()
                Log.i("http", "ErrorImage: ${ex.message}")
            }
            is Result.Success -> {
                val data = result.get()
                val input = data.toByteArray()
                Log.i("testingxd", data)
                Log.i("testingxd","$input")
                x = BitmapFactory.decodeByteArray(input, 0, input.size)
            }
        }
        Log.i("testingxd", "$x")
        return x
    }

}