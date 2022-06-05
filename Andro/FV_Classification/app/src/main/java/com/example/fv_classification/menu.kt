package com.example.fv_classification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.fv_classification.data.detailData
import com.example.fv_classification.data.detailPassing
import com.google.gson.Gson
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var cameraButton = findViewById<ImageButton>(R.id.cameraButton)
        var uploadButton = findViewById<ImageButton>(R.id.uploadButton)
        var detailBuah = findViewById<TextView>(R.id.textView6)



//        var detail = detailPassing("apple")
//        detailBuah.text = detail.lastChild

        cameraButton.setOnClickListener(){
            startActivity(Intent(this@menu, camera::class.java))
        }

        uploadButton.setOnClickListener(){
            startActivity(Intent(this@menu, goal::class.java))
        }
    }


}