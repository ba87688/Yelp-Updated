package com.example.yelptwo.repository

import com.example.yelptwo.api.RetrofitService
import javax.inject.Inject

class RestaurantRepository @Inject constructor(private val restaurantApi: RetrofitService) {
}