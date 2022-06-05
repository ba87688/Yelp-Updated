package com.example.yelptwo.api

import com.example.yelptwo.models.YelpResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {

    companion object{
        const val BASE_URL = "https://api.yelp.com/v3/"
        const val API_KEY = "6l9mK2je6Orff5uKbNz2qlIyTg4T8KOrKJHnvnyHVgKuRah5hf-mR8LyYZFi5R914LIk0KA12yBwy5U3r_VEfq9tDE-9Hwlw16_FNqPKQ6ggnI-jwo4p3dV8nayLYnYx"

    }

    @GET("businesses/search")
    suspend fun searchRestuarants(
        @Header("Authorization") autheader:String,
        @Query("term") searchTerm:String,
        @Query("location") location:String,
        @Query("offset") offset:Int? = null
    ): Response<YelpResponse>
}