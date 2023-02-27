package com.example.mysensor

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener,SensorEventListener {
    lateinit var txt1:TextView
    lateinit var txt2:TextView
    lateinit var spinner:Spinner
    lateinit var manager:SensorManager
    lateinit var sensor:Sensor
    lateinit var allsensor:MutableList<Sensor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt1=findViewById(R.id.textView)
        txt2=findViewById(R.id.textView2)
        spinner=findViewById(R.id.spinner)
        manager=getSystemService(SENSOR_SERVICE) as SensorManager
        allsensor=manager.getSensorList(Sensor.TYPE_ALL)
        var sensor_name= mutableListOf<String>()
        for(name in allsensor)
            sensor_name.add(name.name)
        var adapter=ArrayAdapter(this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,sensor_name)
        spinner.adapter=adapter
        spinner.onItemSelectedListener=this
        sensor=allsensor[0]

    }

    override fun onPause() {
        super.onPause()
        if(sensor!=null)manager.unregisterListener(this,sensor)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(sensor!=null)manager.unregisterListener(this,sensor)
      sensor=allsensor[position]
      txt2.text="Name:${sensor.name}\nVender:${sensor.vendor}\n" +
              "Version${sensor.version}\nMax:${sensor.maximumRange}\nRes:${sensor.resolution}      "
     manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onSensorChanged(event: SensorEvent?) {
        var msg:String=""
        for((index,item)in event!!.values.withIndex())
        {
            msg+="parameter[$index]=$item\n"
        }
        txt1.text=msg
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}


}