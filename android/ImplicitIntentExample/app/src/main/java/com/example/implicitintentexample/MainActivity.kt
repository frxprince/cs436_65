package com.example.implicitintentexample

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_www = findViewById<Button>(R.id.button)
        btn_www.isEnabled = false
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.INTERNET
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.INTERNET), 1234
            )
        } else {
            btn_www.isEnabled = true
            btn_www.setOnClickListener {
                var i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.mju.ac.th"))
                    startActivity(i)
            }
        }
        var btn_alarm=findViewById<Button>(R.id.button2)
        if(ActivityCompat.checkSelfPermission(this,
                "com.android.alarm.permission.SET_ALARM")
        != PackageManager.PERMISSION_GRANTED){
        ActivityCompat.requestPermissions(this,
            arrayOf("com.android.alarm.permission.SET_ALARM"),1234)
        }
        btn_alarm.setOnClickListener {
          var i=Intent(AlarmClock.ACTION_SET_TIMER)
          i.putExtra(AlarmClock.EXTRA_LENGTH,10)
          i.putExtra(AlarmClock.EXTRA_MESSAGE,"Time's up!")
          i.putExtra(AlarmClock.EXTRA_SKIP_UI,true)
          startActivity(i)
        }
//13.7652603,100.5384957
        var btn_map=findViewById<Button>(R.id.button3)
        btn_map.setOnClickListener {
            var i=Intent(Intent.ACTION_VIEW,Uri.parse("geo:13.7652603,100.5384957"))
            startActivity(i)
        }
if (ActivityCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS)
!= PackageManager.PERMISSION_GRANTED){
    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS),
        1234)
}
var btn_phonebook=findViewById<Button>(R.id.button4)
        btn_phonebook.setOnClickListener {
 //var i=Intent(Intent.ACTION_PICK,ContactsContract.Contacts.CONTENT_URI)
   var i=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(i)
        }

    }
}







