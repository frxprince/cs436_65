package com.example.unitconversion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txtinput=findViewById<EditText>(R.id.editTextNumber)
        var btn1 =findViewById<Button>(R.id.button)
        var btn2 = findViewById<Button>(R.id.button2)
        var btn3=findViewById<Button>(R.id.button3)
        var txtview=findViewById<TextView>(R.id.textView)
        btn3.setOnClickListener { finish() }
        btn1.setOnClickListener {
         var inputnumber= if (txtinput.text.toString().length>0)txtinput.text.toString().toDouble() else 0.0
            txtview.text="%.2f".format(inputnumber/2.54)+" inch"
        }
        btn2.setOnClickListener {
            var inputnumber= txtinput.text.toString().toDouble()
            txtview.text="%.2f".format(inputnumber*2.54)+" cm"
        }
    }
}