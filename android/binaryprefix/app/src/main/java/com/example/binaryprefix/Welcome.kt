package com.example.binaryprefix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        var btn1 =findViewById<ImageButton>(R.id.imageButton)
        btn1.setOnClickListener {
     var i= Intent(this,MainActivity::class.java)
       startActivity(i)
        }
    }
}