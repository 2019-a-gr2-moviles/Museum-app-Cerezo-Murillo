package com.example.museum_app.view

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.museum_app.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_museum_detail_view.*

class MuseumAddressMapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var tienePermisosUbicacion = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_address_maps)


        solicitarPermisosUbicacion()
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
        val museumLat = intent.getStringExtra("museumLat")
        val museumLong = intent.getStringExtra("museumLong")
        val museumName = intent.getStringExtra("museumName")
        addMarker(museumLat, museumLong,museumName)
        establecerConfiguracionMapa(mMap)
    }


    fun addMarker(lat:String, long:String, title:String){
        val lat = lat.toDouble()
        val long = long.toDouble()
        val site = LatLng(lat,long)

        mMap.addMarker(
            MarkerOptions()
                .position(site)
                .title(title)
        )
    }

    fun establecerConfiguracionMapa(mapa : GoogleMap){
        val context = this.applicationContext
        with(mapa){

            val tienePermisos = ContextCompat
                .checkSelfPermission(
                    context,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            tienePermisosUbicacion = tienePermisos == PackageManager.PERMISSION_GRANTED
            if(tienePermisosUbicacion) {
                mapa.isMyLocationEnabled = true
            }
            this.uiSettings.isZoomControlsEnabled = true
            uiSettings.isMyLocationButtonEnabled = true
        }
    }

    fun solicitarPermisosUbicacion(){
        val tienePermisos = ContextCompat
            .checkSelfPermission(
                this.applicationContext,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
        this.tienePermisosUbicacion = tienePermisos == PackageManager.PERMISSION_GRANTED
        if(tienePermisosUbicacion){
            Log.i("mapa", "Tiene permisos")
        }else{
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                ),
                1
            )
        }
    }
}
