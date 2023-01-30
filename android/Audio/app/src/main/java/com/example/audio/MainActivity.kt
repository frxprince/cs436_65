package com.example.audio

import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    lateinit var Mp:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    var btnResource=findViewById<Button>(R.id.button)
    var btnPlay=findViewById<Button>(R.id.button5)
    var btnAssets=findViewById<Button>(R.id.button2)
    var btnSDCARD=findViewById<Button>(R.id.button3)
    var btnPause=findViewById<Button>(R.id.button6)
    var btnStop=findViewById<Button>(R.id.button7)
    btnResource.setOnClickListener { Mp=MediaPlayer.create(this,R.raw.greeting) }
    btnPlay.setOnClickListener { Mp.start() }
    btnAssets.setOnClickListener {
    Mp=MediaPlayer()
    var mp3file=assets.openFd("mp3/tada.mp3")
    Mp.setDataSource(mp3file.fileDescriptor,mp3file.startOffset,
    mp3file.length)
        Mp.prepare()
    }
    if(ActivityCompat.checkSelfPermission(this,
        android.Manifest.permission.READ_EXTERNAL_STORAGE) !=PackageManager.PERMISSION_GRANTED){
    ActivityCompat.requestPermissions(this,
        arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE),1234)
    }
   btnSDCARD.setOnClickListener {
    Mp= MediaPlayer();    Mp.setDataSource(
       Environment.getExternalStorageDirectory().path+"/song.mp3");    Mp.prepare()
   }
   btnPause.setOnClickListener { Mp.pause() }
   btnStop.setOnClickListener { Mp.stop() }
        if(ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.INTERNET) !=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.INTERNET),1234)
        }
  var btnInternet=findViewById<Button>(R.id.button4)
  btnInternet.setOnClickListener {
    Mp= MediaPlayer();
    Mp.setDataSource(this, Uri.parse(
        "http://112.121.150.133:9000/stream?type=http&amp;nocache=1590"))
   Mp.prepare()
  }
    }
}