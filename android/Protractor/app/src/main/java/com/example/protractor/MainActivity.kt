package com.example.protractor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.round
import kotlin.text.Typography.degree

class MainActivity : AppCompatActivity(),SensorEventListener {
    lateinit var txt1:TextView
    lateinit var seekbar:SeekBar
    lateinit var manager:SensorManager
    lateinit var sensor:Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt1=findViewById(R.id.textView)
        seekbar=findViewById(R.id.seekBar)
        manager=getSystemService(SENSOR_SERVICE) as SensorManager
        sensor=manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        seekbar.max=180;seekbar.progress=90
        seekbar.progressDrawable=ContextCompat.getDrawable(this,R.mipmap.seekbarbg)
        seekbar.background=ContextCompat.getDrawable(this,R.mipmap.seekbarborder)
    }

    override fun onResume() {
        super.onResume()
        manager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        manager.unregisterListener(this,sensor)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        var degree= 180-((atan2(event!!.values[0],event!!.values[1])/ PI)*180)-90
        txt1.text=degree.toString()
        seekbar.progress=(90-degree).toInt()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }
}