package com.example.fv_classification.data

import com.google.gson.Gson
import okhttp3.*
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.io.IOException

class detailPassing(hasil : String) {

    var x = rune("https://en.wikipedia.org/api/rest_v1/page/summary/${hasil}")

    val client = OkHttpClient()

    lateinit var lastChild : String
    fun rune(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {}
            override fun onResponse(call: okhttp3.Call, response: Response) {
                val listJson = response.body().toString()
                val gson = Gson()
                var mLink = gson.fromJson(listJson, detailData::class.java)
                lastChild = mLink.extract
            }

        })

    }


}