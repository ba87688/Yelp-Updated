package com.example.yelptwo.models

import android.location.Location
import com.google.gson.annotations.SerializedName

data class Business(
    val name: String?,
    val rating: Double,
    val price: String,
    @SerializedName("review_count") val numReviews: Int,
    @SerializedName("distance") val distanceInMeters: Double,
    @SerializedName("image_url") val imageUrl:String,
    val categories : List<YelpCategory>,
    val location: YelpLocation
){

    fun displayDistance():String{
        val milesPerMeter = 0.000621371
        val distanceInMiles = "%.2f".format(distanceInMeters*milesPerMeter)
        return "$distanceInMiles mi"
    }

}

data class YelpCategory(
    val title:String
)
data class YelpLocation(
    @SerializedName("address1") val address:String
)

