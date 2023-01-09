package com.example.binaryprefix

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_inputprefix =findViewById<Button>(R.id.button_inputprefix)
        var textinput=findViewById<EditText>(R.id.editTextNumberDecimal)
        var textoutput=findViewById<TextView>(R.id.textView2)
        var InputPrefixResult=registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
        result:ActivityResult->if (result.resultCode == RESULT_OK){
        //    textoutput.text=result.data?.getStringExtra("prefix")?:"error"
var byteValue=when(result.data!!.getStringExtra("prefix")){
    "kB"->textinput.text.toString().toDouble()* Math.pow(10.0,3.0)
    "GB"->textinput.text.toString().toDouble()* Math.pow(10.0,9.0)
    "MB"->textinput.text.toString().toDouble()* Math.pow(10.0,6.0)
    "TB"->textinput.text.toString().toDouble()* Math.pow(10.0,12.0)
    else->0.0}
            textoutput.text=DecimalFormat("#,###,###").format(byteValue)
        }else{
            textoutput.text="no selection"
        }
        }

       btn_inputprefix.setOnClickListener {
           var i = Intent(this,InputPrefix::class.java)
          InputPrefixResult.launch(i)        //startActivity(i)
       }

    }
}