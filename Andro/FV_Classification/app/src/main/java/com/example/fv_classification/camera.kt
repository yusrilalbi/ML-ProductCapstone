package com.example.fv_classification

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.fv_classification.tflite.Classifier

class camera : AppCompatActivity() {

    private val mInputSize = 150
    private val mModelPath = "converted_modelfruitlama.tflite"
    private val mLabelPath = "labelfruit.txt"
    private lateinit var classifier: Classifier

    val REQUEST_IMAGE_CAPTURE = 100
    lateinit var tombol: Button
    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        initClassifier()

        tombol = findViewById(R.id.buttonFoto)
        imageView = findViewById(R.id.gambar)

        tombol.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            try{
                startActivityForResult(takePictureIntent,REQUEST_IMAGE_CAPTURE)
            }
            catch(e: ActivityNotFoundException){
                Toast.makeText(this,"Error:" + e.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun initClassifier() {
        classifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            val imageBitmap = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)

//            val bitmap = (imageView as BitmapDrawable).bitmap

            var result = classifier.recognizeImage(imageBitmap)
            var judul = findViewById<TextView>(R.id.judul)
            judul.text = result.get(0).title

        }else{
            super.onActivityResult(requestCode, resultCode, data)
        }

    }
}