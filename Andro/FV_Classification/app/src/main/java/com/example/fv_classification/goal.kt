package com.example.fv_classification

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.fv_classification.api.Api
import com.example.fv_classification.data.detailData
import com.example.fv_classification.data.detailPassing
import com.example.fv_classification.data.linkPassing
import com.google.gson.Gson
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.ArrayList

class goal : AppCompatActivity() {

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)

        var gambar = findViewById<ImageView>(R.id.detailGambar)
        var detailBuah = findViewById<TextView>(R.id.detailBuah)
        try {
            var mBitmap = intent.getParcelableExtra<Bitmap>("bitmap")
            var mUri = intent.getParcelableExtra<Uri>("uri")
            var prediksi = intent.getStringExtra("prediksi")

            if (mUri == null)
                //from take picture
                gambar.setImageBitmap(mBitmap)
            else
                //from upload file
                gambar.setImageURI(mUri)

            run("https://en.wikipedia.org/api/rest_v1/page/summary/${prediksi}")
            linkAPI("https://ml-api-productcapstone.herokuapp.com/link/${prediksi}")

        } catch (e: ActivityNotFoundException) {

        }

    }

    fun run(url: String) {
        Log.d("tesurl", url)
        val request = Request.Builder()
            .url(url)
            .build()
        Log.d("tesurl", request.toString())

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {}
            override fun onResponse(call: okhttp3.Call, response: Response) {
                val listJson = response.body()?.string()
                val gson = Gson()
                var mDetail = gson.fromJson(listJson.toString(), detailData::class.java)
                var detailBuah = findViewById<TextView>(R.id.detailBuah)
                var tex = mDetail.extract
                val handler = Handler(Looper.getMainLooper())
                handler.post({
                    detailBuah.text = tex
                })

            }

        })

    }

    fun openLink(url: String) {
        val uris = Uri.parse(url)
        startActivity(Intent(Intent.ACTION_VIEW, uris))
    }

    fun linkAPI(url: String) {
        var urlNew = url.replace(" ", "_")
        val request = Request.Builder()
            .url(urlNew)
            .build()
        try {
            var linkTokped = findViewById<Button>(R.id.tokopedia)
            var linkShopee = findViewById<Button>(R.id.shopee)
            var linkLazada = findViewById<Button>(R.id.lazada)

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: okhttp3.Call, e: IOException) {}
                override fun onResponse(call: okhttp3.Call, response: Response) {
                    val listJson = response.body()?.string()
                    var detailBuah = findViewById<TextView>(R.id.detailBuah)
                    val gson = Gson()
                    var mDetail = gson.fromJson(listJson, Array<String>::class.java)
                    linkTokped.setOnClickListener() {
                        openLink(mDetail[0])
                    }
                    linkShopee.setOnClickListener() {
                        openLink(mDetail[1])
                    }
                    linkLazada.setOnClickListener() {
                        openLink(mDetail[2])
                    }
                }
            })
        }
        catch (e: ActivityNotFoundException) {

        }


    }
}
