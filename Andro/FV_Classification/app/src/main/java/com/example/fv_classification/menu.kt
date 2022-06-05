package com.example.fv_classification

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import com.example.fv_classification.data.detailData
import com.example.fv_classification.data.detailPassing
import com.example.fv_classification.tflite.Classifier
import com.google.gson.Gson
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class menu : AppCompatActivity() {

    lateinit var bitmap: Bitmap
    lateinit var cekkol: TextView
    private lateinit var classifier: Classifier
    lateinit var uploadFile : ImageButton
    lateinit var imageview: ImageView
    private val mInputSize = 150
    private val mModelPath = "converted_modelfruitlama.tflite"
    private val mLabelPath = "labelfruit.txt"
    val REQUEST_IMAGE_CAPTURE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var cameraButton = findViewById<ImageButton>(R.id.cameraButton)
        var uploadButton = findViewById<ImageButton>(R.id.uploadButton)
        var detailBuah = findViewById<TextView>(R.id.textView6)
        cekkol = findViewById(R.id.cekkol)
        uploadFile = findViewById(R.id.uploadButton)
        imageview = findViewById(R.id.apelBesar)
        initClassifier()


//        var detail = detailPassing("apple")
//        detailBuah.text = detail.lastChild

        cameraButton.setOnClickListener(){
            startActivity(Intent(this@menu, camera::class.java))
        }

        uploadButton.setOnClickListener(){

            var intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent,100)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var uri: Uri?= data?.data
        uploadFile.setImageURI(data?.data)
        val imageBitmap = uploadFile.drawable.toBitmap()
        bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)

        var result = classifier.recognizeImage(bitmap)

        uploadFile.setOnClickListener(){
            val intent = Intent(this@menu, goal::class.java)
            intent.putExtra("uri", uri)
            intent.putExtra("prediksi", result.get(0).title)
            startActivity(intent)
        }

    }

    private fun initClassifier() {
        classifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)
    }

}