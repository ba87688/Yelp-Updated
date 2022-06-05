package com.example.yelptwo.models

import com.google.gson.annotations.SerializedName

data class YelpResponse(
    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val businesses: List<Business>
) {
}