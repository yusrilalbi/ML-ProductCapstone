package com.example.fv_classification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var navigate = findViewById<Button>(R.id.getStarted)
        navigate.setOnClickListener(){
            startActivity(Intent(this@MainActivity, menu::class.java))
        }
    }
}