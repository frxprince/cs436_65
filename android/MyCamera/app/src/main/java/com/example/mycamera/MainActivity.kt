package com.example.mycamera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var image1=findViewById<ImageView>(R.id.imageView)
        var bitmap:Bitmap?=null

     var cam_result=registerForActivityResult(
         ActivityResultContracts.StartActivityForResult()){
         result:ActivityResult->
         if(result.resultCode==Activity.RESULT_OK){
         if(bitmap!=null)bitmap?.recycle()
         bitmap=result.data?.extras?.getParcelable<Bitmap>("data")
         image1.setImageBitmap(bitmap)
         }
     }

        image1.setOnClickListener {
     var i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
     cam_result.launch(i)
        }
    }
}