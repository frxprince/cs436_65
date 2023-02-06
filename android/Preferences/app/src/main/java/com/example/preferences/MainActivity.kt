package com.example.preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_load=findViewById<Button>(R.id.button)
        var btn_save=findViewById<Button>(R.id.button2)
        var btn_exit=findViewById<Button>(R.id.button3)
        var text_data1=findViewById<EditText>(R.id.editTextTextPersonName)
        var text_data2=findViewById<EditText>(R.id.editTextTextPersonName2)
        var Pref=getSharedPreferences("mypref", Context.MODE_PRIVATE)

        btn_exit.setOnClickListener { finish() }
        btn_save.setOnClickListener {

        var Pref_edit=Pref.edit()
            Pref_edit.putString("parameter1",text_data1.text.toString())
            Pref_edit.putString("parameter2",text_data2.text.toString())
        Pref_edit.commit()
        }
        btn_load.setOnClickListener {
        var Pref_all=Pref.all
        text_data1.setText(Pref_all.get("parameter1")?.toString()?:"no data")
        text_data2.setText(Pref_all.get("parameter2")?.toString()?:"no data")
        }


    }
}