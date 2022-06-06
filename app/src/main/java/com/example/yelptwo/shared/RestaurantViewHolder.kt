package com.example.yelptwo.shared

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.yelptwo.databinding.ItemRestaurantBinding
import com.example.yelptwo.models.Business
import java.security.AccessController.getContext

class RestaurantViewHolder(private val binding: ItemRestaurantBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(restaurant: Business) {
        binding.apply {
            tvName.text = restaurant.name
            tvName.text = restaurant.name
            ratingBar.rating = restaurant.rating.toFloat()
            tvReviews.text = "${restaurant.numReviews} Reviews"
            tvAddress.text = restaurant.location.address
            tvDistance.text = restaurant.displayDistance()
            tvDollar.text = restaurant.price

            Glide.with(itemView).load(restaurant.imageUrl).apply(
                RequestOptions().transform(
                    CenterCrop(), RoundedCorners(20)
                )
            ).into(imageView)


        }

    }
}