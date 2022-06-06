package com.example.yelptwo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yelptwo.models.Business
import com.example.yelptwo.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "viewmodel"

//@HiltViewModel
//class RestaurantViewModel @Inject constructor( private val repository: RestaurantRepository): ViewModel() {
class RestaurantViewModel() : ViewModel() {

    val repository = RestaurantRepository()

    private val flow = MutableStateFlow<List<Business>>(emptyList())
    val businesses: Flow<List<Business>> = flow

    init {
//
        viewModelScope.launch {
            val restaurants = repository.getRestaurants()
            flow.value = restaurants
//            Log.i(TAG, "view model: $restaurants ")
//            flow.value= restaurants

        }
    }

    suspend fun newSearch(query:String):List<Business>{
        return repository.searchRestaurants2(query)
    }

//    private val currentQuery = MutableStateFlow<String?>(null)
//
//
//
//    val searchResults = currentQuery.flatMapLatest { query->
//        repository.getBreakingRestaurants2(query.toString())
//    }
//    fun onSearchQuerySubmit(query:String){
//        currentQuery.value = query
//    }
    val word = "list"


}