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
class RestaurantRepository () {

    val service = RetrofitFactory.retrofitService


    suspend fun getRestaurants():List<Business>{
        val response=  service.getBreakingRestaurants()
        val businesses = response.businesses
        return businesses

//        val response =  restaurantApi.getBreakingNews()
//        var businesses = response.businesses
////        Log.i(TAG, "getRestaurants: # $bus")
//        businesses.map { it ->
//            Business(
//                name = it.name,
//                rating = it.rating,
//                price = it.price,
//                numReviews = it.numReviews,
//                distanceInMeters = it.distanceInMeters,
//                imageUrl = it.imageUrl,
//                categories = it.categories,
//                location = it.location
//
//            )
//        }
//        return businesses





//        Log.i(TAG, "getRestaurants: resident $response")
//        val business = response.
//        var restaurants = business.body() { it->
//            Business(
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
//
//        }




//        var restaurants:List<Business> =mutableListOf()
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

        return mutableListOf()

    }
}