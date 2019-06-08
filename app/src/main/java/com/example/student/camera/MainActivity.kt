package com.example.student.camera


import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

     val REQUEST_CODE:Int=100
     var img:ImageView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         img=findViewById<ImageView>(R.id.image)
        val btn=findViewById<Button>(R.id.button)

        btn.setOnClickListener {
            val i=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==REQUEST_CODE && resultCode==Activity.RESULT_OK)
        {
            val bitmap:Bitmap = data?.extras?.get("data") as Bitmap
            img?.setImageBitmap(bitmap)
        }
    }
}
