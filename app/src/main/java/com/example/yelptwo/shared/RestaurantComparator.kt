package com.example.yelptwo.shared

import androidx.recyclerview.widget.DiffUtil
import com.example.yelptwo.models.Business

class RestaurantComparator : DiffUtil.ItemCallback<Business> (){
    override fun areItemsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem.location == newItem.location

    }

    override fun areContentsTheSame(oldItem: Business, newItem: Business): Boolean {
        return oldItem == newItem
    }
}