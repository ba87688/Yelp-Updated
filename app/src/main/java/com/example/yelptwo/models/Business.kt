package com.example.yelptwo.models

import android.location.Location
import com.google.gson.annotations.SerializedName

data class Business(
    val name: String,
    val rating: Double,
    val price: String,
    @SerializedName("review_count") val numReviews: Int,
    @SerializedName("distance") val distanceInMeters: Double,
    @SerializedName("image_url") val imageUrl:String,
    val categories : List<YelpCategory>,
    val location: Location
){
    fun displaceDistance():String{
        val milesPerMeter = 0.000621371
        val distanceInMiles = "%.2f".format(distanceInMeters * milesPerMeter)
        return "$distanceInMiles mi"
    }
}

data class YelpCategory(
    @SerializedName("title") val title: String

    )

data class Location(
    @SerializedName("address1") val address:String
)