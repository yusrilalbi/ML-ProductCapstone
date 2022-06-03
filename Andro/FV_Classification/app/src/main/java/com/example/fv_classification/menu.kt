package com.example.fv_classification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var cameraButton = findViewById<ImageButton>(R.id.cameraButton)
        var uploadButton = findViewById<ImageButton>(R.id.uploadButton)

        cameraButton.setOnClickListener(){
            startActivity(Intent(this@menu, camera::class.java))
        }

        uploadButton.setOnClickListener(){
            startActivity(Intent(this@menu, goal::class.java))
        }
    }
}