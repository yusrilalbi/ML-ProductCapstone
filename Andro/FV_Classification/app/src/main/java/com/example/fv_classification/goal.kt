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

class goal : AppCompatActivity() {

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)

        var gambar = findViewById<ImageView>(R.id.detailGambar)
        var linkTokped = findViewById<Button>(R.id.tokopedia)
        var linkShopee = findViewById<Button>(R.id.shopee)
        var linkLazada = findViewById<Button>(R.id.lazada)
//        var detailBuah = findViewById<TextView>(R.id.detailBuah)
        var link = linkPassing()

        try{
            var mBitmap = intent.getParcelableExtra<Bitmap>("bitmap")
            var mUri = intent.getParcelableExtra<Uri>("uri")
            var prediksi = intent.getStringExtra("prediksi")
            if (mUri == null)
                gambar.setImageBitmap(mBitmap)
            else
                gambar.setImageURI(mUri)
//            detailBuah.text = "${prediksi}"
            linkTokped.setOnClickListener(){
                openLink("https://www.tokopedia.com/search?st=product&q=${prediksi}")
            }
            linkShopee.setOnClickListener(){
                openLink("https://shopee.co.id/search?keyword=${prediksi}")
            }
            linkLazada.setOnClickListener(){
                openLink("https://www.lazada.co.id/catalog/?q=${prediksi}&_keyori=ss&from=input")
            }

            run("https://en.wikipedia.org/api/rest_v1/page/summary/${prediksi}")

        }
        catch(e: ActivityNotFoundException){
            linkShopee.text = "ERROR"
        }

    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {}
            override fun onResponse(call: okhttp3.Call, response: Response) {
                val listJson = response.body()?.string()
                val gson = Gson()
                var mDetail = gson.fromJson(listJson.toString(), detailData::class.java)
                var detailBuah = findViewById<TextView>(R.id.detailBuah)
                Log.d("sayakuti", mDetail.extract.toString())
                var tex = mDetail.extract.toString()
//                detailBuah.text = "tex"
                val handler = Handler(Looper.getMainLooper())
                handler.post({
                    detailBuah.text = tex
                })

            }

        })

    }

    fun openLink(url: String){
        val uris = Uri.parse(url)
        startActivity(Intent(Intent.ACTION_VIEW, uris))
    }
}
