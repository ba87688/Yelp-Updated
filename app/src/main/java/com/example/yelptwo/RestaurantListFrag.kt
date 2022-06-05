package com.example.yelptwo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yelptwo.databinding.RestaurantListFragBinding
import com.example.yelptwo.shared.RestaurantAdapter
import com.example.yelptwo.viewmodel.RestaurantViewModel
import kotlinx.coroutines.flow.collect

class RestaurantListFrag:Fragment(R.layout.restaurant_list_frag) {

    private val viewModel:RestaurantViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = RestaurantListFragBinding.bind(view)
        val restaurantAdapter =RestaurantAdapter()

        binding.apply {
            rvFrag.apply {
                adapter= restaurantAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }

            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.businesses.collect {businesses->
                    restaurantAdapter.submitList(businesses)

                }
            }



        }



    }
}