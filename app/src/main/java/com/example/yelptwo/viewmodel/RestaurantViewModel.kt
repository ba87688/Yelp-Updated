package com.example.yelptwo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yelptwo.models.Business
import com.example.yelptwo.repository.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor( private val repository: RestaurantRepository): ViewModel() {


    private val flow  = MutableStateFlow<List<Business>>(emptyList())
    val businesses :Flow<List<Business>> = flow

    init {

        viewModelScope.launch {
            val restaurants = repository.getRestaurants()
            flow.value= restaurants

        }
    }
    val word = "list"


}