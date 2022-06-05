package com.example.yelptwo.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    val retrofit = Retrofit.Builder().baseUrl(RetrofitService.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: RetrofitService by lazy {
        retrofit.create(RetrofitService::class.java)
    }
}