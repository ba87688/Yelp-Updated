package com.example.yelptwo.repository

import android.util.Log
import com.example.yelptwo.api.RetrofitService
import com.example.yelptwo.models.Business
import com.example.yelptwo.models.YelpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


const val TAG = "RestaurantRepository"
class RestaurantRepository @Inject constructor(private val restaurantApi: RetrofitService) {

    suspend fun getRestaurants():List<Business>{

        val response =  restaurantApi.searchRestuarants().body()

        Log.i(TAG, "getRestaurants: resident $response")

//        var restaurants:List<Business> =mutableListOf()
//        val response =  restaurantApi.searchRestuarants().body()
//        Log.i(TAG, "getRestaurants: RESIDENT $response")
//        if (response!=null) {
//            val business = response.businesses
//             restaurants = business.map { it
//                Business(
//                    name = it.name,
//                    rating = it.rating,
//                    price = it.price,
//                    numReviews =  it.numReviews,
//                    distanceInMeters = it.distanceInMeters,
//                    imageUrl = it.imageUrl,
//                    categories = it.categories,
//                    location = it.location
//
//                )
//            }
//        }
//        return restaurants!!

        return response?.businesses!!
    }
}