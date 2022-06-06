package com.example.yelptwo

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yelptwo.databinding.RestaurantListFragBinding
import com.example.yelptwo.repository.RestaurantRepository
import com.example.yelptwo.shared.RestaurantAdapter
import com.example.yelptwo.shared.onQueryTextSubmit
import com.example.yelptwo.viewmodel.RestaurantViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RestaurantListFrag : Fragment(R.layout.restaurant_list_frag) {

    private val viewModel: RestaurantViewModel by viewModels()
    private val restaurantAdapter = RestaurantAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = RestaurantListFragBinding.bind(view)
//        val restaurantAdapter = RestaurantAdapter()

        binding.apply {
            rvFrag.apply {
                adapter = restaurantAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }

            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.businesses.collect { businesses ->
                    restaurantAdapter.submitList(businesses)

                }
            }


        }



    }

    //create a menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
        val searchItem = menu.findItem(R.id.action_search)

        val searchView = searchItem?.actionView as androidx.appcompat.widget.SearchView

       searchView.onQueryTextSubmit {query->
//           viewModel.onSearchQuerySubmit(query)

           val rep = RestaurantRepository()

           viewLifecycleOwner.lifecycleScope.launch {
               val restaurants =viewModel.newSearch(query)
//               val r =rep.searchRestaurants2(query)
               restaurantAdapter.submitList(restaurants)
           }
           searchView.clearFocus()
       }


    }



}