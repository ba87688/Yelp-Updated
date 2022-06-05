package com.example.yelptwo.shared

import androidx.recyclerview.widget.RecyclerView
import com.example.yelptwo.databinding.ItemRestaurantBinding
import com.example.yelptwo.models.Business

class RestaurantViewHolder (private val binding: ItemRestaurantBinding): RecyclerView.ViewHolder(binding.root) {


    fun bind(restaurant: Business){
        binding.apply {
            tvName.text = restaurant.name
        }
    }
}