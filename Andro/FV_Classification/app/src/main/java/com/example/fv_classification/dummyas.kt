package com.example.fv_classification

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import com.example.fv_classification.data.detailData
import com.example.fv_classification.tflite.Classifier
import com.google.gson.Gson
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class dummyas : AppCompatActivity() {

    private val mInputSize = 150
    private val mModelPath = "converted_modelfruitlama.tflite"
    private val mLabelPath = "labelfruit.txt"
    private lateinit var classifier: Classifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummyas)

        initClassifier()
        var imageter = findViewById<ImageView>(R.id.one)
        var texkan = findViewById<TextView>(R.id.teskan)

        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.imgbellpaper)
        var result = classifier.recognizeImage(bitmap)
        texkan.text = "${texkan.text} \n${result.get(0).title}"

        bitmap = BitmapFactory.decodeResource(resources, R.drawable.banana)
        result = classifier.recognizeImage(bitmap)
        texkan.text = "${texkan.text} \n${result.get(0).title}"

        bitmap = BitmapFactory.decodeResource(resources, R.drawable.apple)
        result = classifier.recognizeImage(bitmap)
        texkan.text = "${texkan.text} \n${result.get(0).title}"

        bitmap = BitmapFactory.decodeResource(resources, R.drawable.jeruk)
        result = classifier.recognizeImage(bitmap)
        texkan.text = "${texkan.text} \n${result.get(0).title}"

        bitmap = BitmapFactory.decodeResource(resources, R.drawable.kiwi)
        result = classifier.recognizeImage(bitmap)
        texkan.text = "${texkan.text} \n${result.get(0).title}"

    }

    private fun initClassifier() {
        classifier = Classifier(assets, mModelPath, mLabelPath, mInputSize)
    }



}