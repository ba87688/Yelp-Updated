package com.example.yelptwo.repository

import android.util.Log
import com.example.yelptwo.api.RetrofitFactory
import com.example.yelptwo.api.RetrofitService
import com.example.yelptwo.models.Business
import com.example.yelptwo.models.YelpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


const val TAG = "RestaurantRepository"

//class RestaurantRepository @Inject constructor(private val restaurantApi: RetrofitService) {
class RestaurantRepository() {

    val service = RetrofitFactory.retrofitService


    suspend fun getRestaurants(): List<Business> {
        val response = service.getBreakingRestaurants()
        val businesses = response.businesses
        return businesses


        return mutableListOf()

    }


    suspend fun searchRestaurants2(query:String): List<Business> {

        val response = service.getBreakingRestaurants2(searchTerm = query)
        val businesses = response.businesses
        return businesses


        return mutableListOf()

    }
}