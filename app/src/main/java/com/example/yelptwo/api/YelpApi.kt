package com.example.yelptwo.api
//
//import com.example.yelptwo.api.YelpService.Companion.BASE_URL
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//object YelpApi {
//
//    val retrofit = Retrofit.Builder().baseUrl(YelpService.BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val retrofitService: YelpService by lazy {
//        retrofit.create(YelpService::class.java)
//    }
//}