package com.example.gps

import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.location.OnNmeaMessageListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity(),LocationListener,OnNmeaMessageListener {
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    lateinit var gps:LocationManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    txt1=findViewById(R.id.textView)
    txt2=findViewById(R.id.textView2)
    gps=getSystemService(LOCATION_SERVICE) as LocationManager
    }
    override fun onResume() {
        super.onResume()
       if( ActivityCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)!=
               PackageManager.PERMISSION_GRANTED) {
           ActivityCompat.requestPermissions(
               this, arrayOf(
                   android.Manifest.permission.ACCESS_FINE_LOCATION,
                   android.Manifest.permission.ACCESS_COARSE_LOCATION
               ), 1354
           )
       }else{
       gps.requestLocationUpdates(LocationManager.GPS_PROVIDER,1000,10f,this)
       gps.addNmeaListener(this)
       }
    }
    override fun onPause() {
        super.onPause()
        gps.removeUpdates(this)
    }
    override fun onLocationChanged(location: Location) {
        txt1.text="Lat:${location.latitude}\nLong:${location.longitude}\nAlt:${location.altitude}\n" +
                "Clock:${location.time}\nSpeed:${location.speed}\nBaring:${location.bearing}"
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
//        super.onStatusChanged(provider, status, extras)
    }

    override fun onNmeaMessage(message: String?, timestamp: Long) {
        txt2.text=message+"\n"+txt2.text;if(txt2.text.length>300)txt2.text=""
    }
}