package com.example.fv_classification.api

import com.example.fv_classification.data.linkData
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("https://indodax.com/api/pairs")
    fun getDatag(): Call<ArrayList<linkData>>
}